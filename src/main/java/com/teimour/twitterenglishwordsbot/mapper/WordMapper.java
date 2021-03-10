package com.teimour.twitterenglishwordsbot.mapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author kebritam
 * Project twitter-english-words-bot
 * Created on 07/03/2021
 */

@Mapper
public interface WordMapper {
    String getWord();
}
