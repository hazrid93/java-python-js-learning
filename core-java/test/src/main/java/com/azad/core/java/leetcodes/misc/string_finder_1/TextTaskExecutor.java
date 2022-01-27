package com.azad.core.java.leetcodes.misc.string_finder_1;

import java.util.Stack;

public class TextTaskExecutor implements TextProcessor{
    private Stack<String> wordsList;

    public TextTaskExecutor(Stack<String> wordsList) {
        this.wordsList = wordsList;
    }

    @Override
    public void execute() {
        while(!this.wordsList.isEmpty()) {
            String item = wordsList.pop();
            System.out.println(item);
        }
    }
}
