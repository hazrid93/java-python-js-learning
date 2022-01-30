package com.azad.core.java.leetcodes.misc.string_finder_2.utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;

public class TextGenerator {
    private static final int wordCount = 10;
    /**
     * @return return a thread safe {@link Stack} with String to process
     */
    public static Map<String, Boolean> returnText(){
        Map<String, Boolean> wordStack = new LinkedHashMap<>();
        for(int i=0; i<wordCount ; i++){
            String randomWord =  RandomStringUtils.randomAlphabetic(10);
            // boolean false to signify it hasnt been parsed
            wordStack.put(randomWord, false);
        }
        return wordStack;
    }
}
