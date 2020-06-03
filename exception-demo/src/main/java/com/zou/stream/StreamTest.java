package com.zou.stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @ClassName StreamTest
 * @Description TODO
 * @Author zouyouxiu
 * @Date 2019/12/25 23:27
 */
public class StreamTest {
    public static void main(String[] args) {
        //根据Collection获取流
        ArrayList<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();
        HashSet<String> set = new HashSet<>();
        Stream<String> stream1 = set.stream();

        //根据Map获取流
        //Map接口不是 Collection 的子接口,且其K-V数据结构不符合流元素的单一特征，所以获取对应的流 需要分key、value或entry等情况
        HashMap<String, String> map = new HashMap<>();
        Stream<String> stream2 = map.keySet().stream();
        Stream<String> stream3 = map.values().stream();
        Stream<Map.Entry<String, String>> stream4 = map.entrySet().stream();

        //根据数组获取流
        int [] arr={1,2,3,4,5,6};
        //of方法的参数是一个可变参数，所以支持数组
        Stream<int[]> arr1 = Stream.of(arr);
    }
}
