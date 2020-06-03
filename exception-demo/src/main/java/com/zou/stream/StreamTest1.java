package com.zou.stream;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @ClassName StreamTest1
 * @Description TODO
 * @Author zouyouxiu
 * @Date 2019/12/26 0:25
 */
public class StreamTest1 {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("10", "12","14");
        long count = stream.count();
        System.out.println(count);
    }
}
