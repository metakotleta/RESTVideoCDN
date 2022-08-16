package ru.rvukolov.restvideocdn.model.bot;

import lombok.Getter;
import lombok.Setter;
import ru.rvukolov.restvideocdn.model.in.MovieMedia;
import ru.rvukolov.restvideocdn.model.in.Qualities;
import ru.rvukolov.restvideocdn.model.in.Translation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class ShortMovieMedia {
    private long id;
    private int max_quality;
    private String path;
    private int duration;
    private Map<Long, Qualities> qualities;
    private Translation translation;

    public ShortMovieMedia(MovieMedia movieMedia) {
        this.id = movieMedia.getId();
        this.max_quality = movieMedia.getMax_quality();
        this.path = movieMedia.getPath();
        this.duration = movieMedia.getDuration();
        this.qualities = movieMedia.getQualities();
        this.translation = movieMedia.getTranslation();
    }

    public void setQualities(Qualities[] qualities) {
        this.qualities = new HashMap<Long, Qualities>();
        Arrays.stream(qualities).forEach(q -> this.qualities.put(q.getId(), q));
    }
}
