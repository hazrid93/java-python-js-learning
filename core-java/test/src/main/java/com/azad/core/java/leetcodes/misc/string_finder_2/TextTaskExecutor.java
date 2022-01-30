package com.azad.core.java.leetcodes.misc.string_finder_2;

import java.util.Map;
import java.util.Optional;

public class TextTaskExecutor implements TextProcessor {
    private final Map<String, Boolean> wordsList;

    // to use as monitor object
    private final Object lock = new Object();


    public TextTaskExecutor(Map<String, Boolean> wordsList) {
        this.wordsList = wordsList;
    }

    @Override
    public void execute() throws Exception {
        synchronized (lock) {
            try {
                Optional<Map.Entry<String, Boolean>> item = fetchWord();
                if (item.isPresent()) {
                    Map.Entry<String, Boolean> getItem = item.get();
                    this.setWordFlag(getItem.getKey());
                    System.out.println(getItem.getKey() + ", " + wordsList.get(getItem.getKey()) + ", processed by: " + Thread.currentThread().getName());
                } else {
                    throw new Exception("Word item is finished");
                }
            } catch (Exception ex) {
                System.out.println("in execute(): " + ex.getMessage());
                throw ex;
            }

        }
    }
    public Optional<Map.Entry<String, Boolean>> fetchWord(){
        Optional<Map.Entry<String, Boolean>> item = wordsList.entrySet()
                .stream()
                .filter(x -> x.getValue() == false)
                .findFirst();
        return item;
    }

    public void setWordFlag(String key){
        wordsList.replace(key, true);
    }
}
