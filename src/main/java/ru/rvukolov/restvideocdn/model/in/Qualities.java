package ru.rvukolov.restvideocdn.model.in;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Qualities {
    private long id;
    private String url;
    private int resolution;
    private int media_id;
    private String direct_link;
}
