package ru.rvukolov.restvideocdn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.rvukolov.restvideocdn.model.bot.ShortMovieEntity;
import ru.rvukolov.restvideocdn.model.in.MovieEntity;
import ru.rvukolov.restvideocdn.model.in.MovieResult;
import ru.rvukolov.restvideocdn.service.ExternalRestService;
import ru.rvukolov.restvideocdn.service.VideoCDNParserService;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MoviesController {

    private ExternalRestService externalRestService;
    private VideoCDNParserService videoCDNParserService;

    @Autowired
    public MoviesController(ExternalRestService externalRestService, VideoCDNParserService videoCDNParserService) {
        this.externalRestService = externalRestService;
        this.videoCDNParserService = videoCDNParserService;
    }

    @GetMapping
    public List<MovieEntity> getMovieByTitle(@RequestParam String title) {
        return externalRestService.getMoviesByTitle(title);
    }

    @GetMapping("/{id}")
    public MovieResult getByMovieId(@PathVariable long id) {
        return externalRestService.getByMovieId(id);
    }

    /**
    * TODO: Ниже тестовые методы, удалить, будет использоваться из-под бота
    */
    @GetMapping("/bot")
    public List<ShortMovieEntity> getBotMovieByTitle(@RequestParam String title) {
        return externalRestService.getByMovieByTitleForBot(title, 15);
    }

}
