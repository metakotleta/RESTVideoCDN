package ru.rvukolov.restvideocdn.model.in;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieEntity {
    private long id;
    private String ru_title;
    private String orig_title;
    private String imdb_id;
    private String kinopoisk_id;
    private int content_id;
    private String content_type;
    private Map<Long, MovieMedia> media;

    public void setMedia(MovieMedia[] media) {
        this.media = new HashMap<Long, MovieMedia>();
        Arrays.stream(media).forEach(m -> this.media.put(m.getId(), m));
    }
}
