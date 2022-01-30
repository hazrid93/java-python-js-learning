package com.azad.core.java.java_11.string_api;

import java.util.ArrayList;
import java.util.List;

/**
 * String.repeat(int) − Repeats a string given number of times. Returns the concatenated string.
 * String.isBlank() − Checks if a string is empty or not empty but have white spaces only.
 * String.isEmpty() − Checks if a string is empty length == 0 only, but might give true if only have >1 blank space (better to use isBlank())
 * String.strip() − Removes the leading and trailing whitespaces.
 * String.stripLeading() − Removes the leading whitespaces.
 * String.stripTrailing() − Removes the trailing whitespaces.
 * String.lines() − Return the stream of lines of multi-line string.
 */
public class string_1 {
    public static void main(String[] args) {
        String sample = " abc ";
        System.out.println(sample.repeat(2)); // " abc  abc "
        System.out.println(sample.isBlank()); // false
        System.out.println("".isBlank()); // true
        System.out.println("   ".isBlank()); // true
        System.out.println(sample.strip()); // "abc"
        System.out.println(sample.stripLeading()); // "abc "
        System.out.println(sample.stripTrailing()); // " abc"
        System.out.println(sample.isEmpty()); // " false"
        sample = "This\nis\na\nmultiline\ntext.";

        /*
        List<String> lines = new ArrayList<>();
        sample.lines().forEach(line -> lines.add(line));
        lines.forEach(line -> System.out.println(line));
        */
    }
}
