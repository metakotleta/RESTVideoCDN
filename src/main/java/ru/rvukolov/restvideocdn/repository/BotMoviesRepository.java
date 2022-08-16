package ru.rvukolov.restvideocdn.repository;

import org.springframework.stereotype.Repository;
import ru.rvukolov.restvideocdn.model.bot.ShortMovieEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("botMoviesRepository")
public class BotMoviesRepository {
    private Map<Long, List<ShortMovieEntity>> chatMoviesMap;

    public BotMoviesRepository() {
        this.chatMoviesMap = new HashMap<>();
    }

    public void putChatMovie(long chatId, List<ShortMovieEntity> shortMovieEntityList) {
        chatMoviesMap.put(chatId, shortMovieEntityList);
    }
}
