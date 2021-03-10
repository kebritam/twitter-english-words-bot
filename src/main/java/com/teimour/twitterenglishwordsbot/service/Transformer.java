package com.teimour.twitterenglishwordsbot.service;

import com.teimour.twitterenglishwordsbot.domain.Word;
import com.teimour.twitterenglishwordsbot.exception.NotFoundException;
import com.teimour.twitterenglishwordsbot.mapper.WordMapper;
import org.springframework.web.client.RestTemplate;

import java.util.TimerTask;

/**
 * @author kebritam
 * Project twitter-english-words-bot
 * Created on 08/03/2021
 */

public class Transformer extends TimerTask {

    private final WordMapper wordMapper;

    public Transformer(WordMapper wordMapper) {
        this.wordMapper = wordMapper;
    }

    @Override
    public void run() {
        String wordValue = wordMapper.getWord();
        if (wordValue == null)
            throw new NotFoundException("word list is empty");

        RestTemplate template = new RestTemplate();
        Word word = template.getForObject("dictionary get uri" + wordValue, Word.class);

        if (word == null)
            throw new NotFoundException("word does not exist in dictionary");

        String jsonForm = word.wordValue + word.wordClasses + word.definitions;
        template.postForObject("twitter post uri", jsonForm, Void.class);
    }
}
