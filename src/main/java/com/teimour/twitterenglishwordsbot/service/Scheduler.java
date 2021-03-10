package com.teimour.twitterenglishwordsbot.service;

import com.teimour.twitterenglishwordsbot.mapper.WordMapper;

import java.util.Calendar;
import java.util.Timer;

/**
 * @author kebritam
 * Project twitter-english-words-bot
 * Created on 08/03/2021
 */

public class Scheduler {
    private static final Calendar calendar = Calendar.getInstance();
    private static final Timer timer = new Timer();

    public Scheduler() {
        throw new IllegalCallerException("class should not be instantiated");
    }

    public static void scheduleForDays(WordMapper wordMapper) {
        int dayAfter = 1000 * 60 * 60 * 24;

        calendar.set(Calendar.HOUR_OF_DAY, 8);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        timer.schedule(
                new Transformer(wordMapper),
                calendar.getTime(),
                dayAfter
        );

        calendar.set(Calendar.HOUR_OF_DAY, 13);
        timer.schedule(
                new Transformer(wordMapper),
                calendar.getTime(),
                dayAfter
        );

        calendar.set(Calendar.HOUR_OF_DAY, 19);
        timer.schedule(
                new Transformer(wordMapper),
                calendar.getTime(),
                dayAfter
        );
    }
}
