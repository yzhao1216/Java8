package com.java8.StreamAPI;

import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * Created by yizhao on 4/1/2018.
 */
public class TestStream {
    public static void main(String[] args) {
        Stream<String> words = Pattern.compile("[\\P{L}]+").splitAsStream("i am a boy, you are a girl.");

        //words.forEach(s -> System.out.println(s));

//        Stream<String> longWords = words.filter(s -> s.length()>2);
//        longWords.forEach(s -> System.out.println(s));

        Stream<String> upperCase = words.map(String::toUpperCase);
        upperCase.forEach(w -> System.out.println(w));
    }
}
