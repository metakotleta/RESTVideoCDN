package ru.rvukolov.restvideocdn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import ru.rvukolov.restvideocdn.model.bot.ShortMovieEntity;
import ru.rvukolov.restvideocdn.model.in.MovieEntity;
import ru.rvukolov.restvideocdn.model.in.MovieResult;
import ru.rvukolov.restvideocdn.repository.BotMoviesRepository;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

@Service("externalRestService")
public class ExternalRestService {
    private final static String VIDEOCDN_API = "https://videocdn.tv/api";
    private final static String MOVIES_PATH = "/movies";
    private final static String TOKEN = "RffgWU3yiEwFl0OIqqUmsKFgf8OeLjay";
    private BotMoviesRepository botMoviesRepository;

    private final RestTemplate restTemplate;
    @Autowired
    public ExternalRestService(BotMoviesRepository botMoviesRepository) {
        this.restTemplate = new RestTemplateBuilder().build();
    }

    //TODO: возможно вынести в отдельный service для бота и связать с этим service?
    public List<ShortMovieEntity> getByMovieByTitleForBot(String title, long chatId) {
        var movieEntities = getMoviesByTitle(title);
        var shortMovieEntities =  movieEntities.stream().map(ShortMovieEntity::new).collect(Collectors.toList());
        botMoviesRepository.putChatMovie(chatId, shortMovieEntities);
        return shortMovieEntities;
    }

    public void getMediaByMovieId(List<ShortMovieEntity> shortMovieEntityList) {
        //TODO: получить список Media, написать метод для возвращения Qualities
    }
    public List<MovieEntity> getMoviesByTitle(String title) throws NullPointerException {
        String url = VIDEOCDN_API;
        HttpHeaders headers = new HttpHeaders();
        headers.set("API-TOKEN", TOKEN);
        HttpEntity<?> requestEntity = new HttpEntity<>(headers);
        String urlTemplate = UriComponentsBuilder.fromHttpUrl(url)
                .path(MOVIES_PATH)
                .queryParam("field", "title")
                .queryParam("query", URLEncoder.encode(title, StandardCharsets.UTF_8))
                .encode().toUriString();

        var response = restTemplate.exchange(urlTemplate, HttpMethod.GET, requestEntity, MovieResult.class).getBody().getData();
        return response;
    }

    public MovieResult getByMovieId(long id) {
        String url = VIDEOCDN_API;
        HttpHeaders headers = new HttpHeaders();
        headers.set("API-TOKEN", TOKEN);
        HttpEntity<?> requestEntity = new HttpEntity<>(headers);
        String urlTemplate = UriComponentsBuilder.fromHttpUrl(url)
                .path(MOVIES_PATH)
                .path("/"+id)
                .encode().toUriString();

        var response = restTemplate.exchange(urlTemplate, HttpMethod.GET, requestEntity, MovieResult.class);
        var body = response.getBody();
        return body;
    }
}
