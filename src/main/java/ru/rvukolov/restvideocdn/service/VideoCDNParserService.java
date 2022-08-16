package ru.rvukolov.restvideocdn.service;

import org.jsoup.Jsoup;
import org.springframework.stereotype.Service;
import ru.rvukolov.restvideocdn.model.in.MovieResult;

import java.io.IOException;

@Service("videoCDNParserService")
public class VideoCDNParserService {

    private static final String USER_AGENT = "Chrome/4.0.249.0 Safari/532.5";
    private static final String REFERRER = "http://www.google.com";

    public void setQualitiesDirectLink(MovieResult movieResult) throws IOException {
        var jsoup = Jsoup.connect("url").userAgent(USER_AGENT).referrer(REFERRER).get();
        jsoup.getElementsByTag("video");
    }
}
