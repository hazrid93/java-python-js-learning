package com.azad.core.java.leetcodes.misc.string_finder_1.utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Stack;

public class TextGenerator {
    private static final int wordCount = 6;
    /**
     * @return return a thread safe {@link java.util.Stack} with String to process
     */
    public static Stack<String> returnText(){
        Stack<String> wordStack = new Stack<>();
        for(int i=0; i<wordCount ; i++){
            String randomWord =  RandomStringUtils.randomAlphabetic(5);
            wordStack.push(randomWord);
        }
        return wordStack;
    }

}
