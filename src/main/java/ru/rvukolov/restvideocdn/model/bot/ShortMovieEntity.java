package ru.rvukolov.restvideocdn.model.bot;

import lombok.Getter;
import lombok.Setter;
import ru.rvukolov.restvideocdn.model.in.MovieEntity;
import ru.rvukolov.restvideocdn.model.in.MovieMedia;

import java.security.KeyStore;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class ShortMovieEntity {
    private long id;
    private String ru_title;
    private Map<Long, ShortMovieMedia> media;

    public ShortMovieEntity(MovieEntity movieEntity) {
        this.id = movieEntity.getId();
        this.ru_title = movieEntity.getRu_title();
        this.media = new HashMap<>();
        for (Map.Entry<Long, MovieMedia> entry : movieEntity.getMedia().entrySet()) {
            this.media.put(entry.getKey(), new ShortMovieMedia(entry.getValue()));
        }
    }
}
