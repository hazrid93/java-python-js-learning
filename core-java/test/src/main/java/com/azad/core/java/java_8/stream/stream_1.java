package com.azad.core.java.java_8.stream;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Type of stream - stream()  & parallelStream()
 * Sequence of elements − A stream provides a set of elements of specific type in a sequential manner. A stream gets/computes elements on demand. It never stores the elements.
 * Source − Stream takes Collections, Arrays, or I/O resources as input source.
 * Aggregate operations − Stream supports aggregate operations like filter, map, limit, reduce, find, match, and so on
 * Pipelining − Most of the stream operations return stream itself so that their result can be pipelined. These operations are called intermediate operations and their function is to take input, process them, and return output to the target. collect() method is a terminal operation which is normally present at the end of the pipelining operation to mark the end of the stream.
 * Automatic iterations − Stream operations do the iterations internally over the source elements provided, in contrast to Collections where explicit iteration is required.
 */
public class stream_1 {
    public static void main(String[] args){
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");

        /// stream generation example with stream()
        List<String> filtered = strings.stream().filter(item -> !item.isEmpty()).collect(Collectors.toList());
        System.out.println("filtered: " + filtered);

        /// using 'forEach' to iterate element of stream
        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);

        /// map() method is used to map each element to its corresponding result it will return the array transformed
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        //get list of unique squares
        List<Integer> squaresList = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());
        System.out.println("squaresList: " + squaresList);

        /// filter()  used to eliminate elements based on a criteria
        List<String> strings2 = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        //get count of empty string
        long count = strings2.stream().filter(item -> item.isEmpty()).count();

        /// limit() method is used to reduce the size of the stream
        Random random2 = new Random();
        System.out.println("limit() example: ");
        random2.ints().limit(10).forEach(System.out::println);

        /// sorted()  is used to sort the stream
        System.out.println("sorted() example: ");
        random2.ints().limit(10).sorted().forEach(System.out::println);

        /// parallelStream() alternative of stream for parallel processing
        long count2 = strings2.parallelStream().filter(string -> !string.isEmpty()).count();
        System.out.println("parallelStream() example: " + count2);

        /// collect() combine the result of processing on the elements of a stream. Collectors can be used to return a list or a string.
        List<String> strings3 = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<String> filtered3 = strings.stream().filter(item -> !item.isEmpty()).collect(Collectors.toList()); //collect as list

        System.out.println("Filtered List: " + filtered3);
        String mergedString = strings3.stream().filter(item -> !item.isEmpty()).collect(Collectors.joining(", ")); // collect as string
        System.out.println("Merged String: " + mergedString);

        /// statistic() calculate all statistics when stream processing is being done.
        List<Integer> numbers2 = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        IntSummaryStatistics stats = numbers2.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("Highest number in List : " + stats.getMax());
        System.out.println("Lowest number in List : " + stats.getMin());
        System.out.println("Sum of all numbers : " + stats.getSum());
        System.out.println("Average of all numbers : " + stats.getAverage());

    }
}
