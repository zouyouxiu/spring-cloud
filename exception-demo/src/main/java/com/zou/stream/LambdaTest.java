package com.zou.stream;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @ClassName LambdaTest
 * @Description TODO
 * @Author zouyouxiu
 * @Date 2019/12/26 17:45
 */
public class LambdaTest {
    public static void main(String[] args) {
        consume(s -> System.out.println(s))                                                                                                                                                                                                                                                                                                                                                                                    ;
    }


    private static void consume(Consumer<String> function) {
        function.accept("Hello");
    }
}
