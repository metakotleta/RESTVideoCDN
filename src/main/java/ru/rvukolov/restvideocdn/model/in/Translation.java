package ru.rvukolov.restvideocdn.model.in;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Translation {
    private int id;
    private String title;
    private int priority;
    private String iframe_src;
    private String iframe;
    private String short_title;
    private String smart_title;
    private String shorter_title;
}
