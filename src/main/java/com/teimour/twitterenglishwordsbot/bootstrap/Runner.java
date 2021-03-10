package com.teimour.twitterenglishwordsbot.bootstrap;

import com.teimour.twitterenglishwordsbot.mapper.WordMapper;
import com.teimour.twitterenglishwordsbot.service.Scheduler;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author kebritam
 * Project twitter-english-words-bot
 * Created on 08/03/2021
 */

@Component
class Runner implements CommandLineRunner {

    private final WordMapper wordMapper;

    public Runner(WordMapper wordMapper) {
        this.wordMapper = wordMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        Scheduler.scheduleForDays(wordMapper);
    }
}
