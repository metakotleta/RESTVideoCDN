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
public class MovieMedia {
    private long id;
    private int translation_id;
    private int content_id;
    private String content_type;
    private int tv_series_id;
    private String source_quality;
    private int max_quality;
    private String path;
    private int duration;
    private String created;
    private String accepted;
    private String deleted_at;
    private int blocked;
    private int count_download;
    private Map<Long, Qualities> qualities;
    private Translation translation;

    public void setQualities(Qualities[] qualities) {
        this.qualities = new HashMap<Long, Qualities>();
        Arrays.stream(qualities).forEach(q -> this.qualities.put(q.getId(), q));
    }
}
