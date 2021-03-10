package com.teimour.twitterenglishwordsbot.domain;

import java.util.*;

/**
 * @author kebritam
 * Project twitter-english-words-bot
 * Created on 07/03/2021
 */

public class Word {

    public UUID uuid;

    public String wordValue;

    public final List<WordClass> wordClasses;

    public final List<String> definitions;

    public Word() {
        wordClasses = new LinkedList<>();
        definitions = new LinkedList<>();
    }
}
