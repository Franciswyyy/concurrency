package com.wang.concurrency.example.immutable;

import com.google.common.collect.Maps;
import com.wang.concurrency.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
@NotThreadSafe
public class ImmutableExample1 {

    //final修饰基本数据类型是不能修改的，但是修饰引用时可以改的

    private final static Integer a = 1;
    private final static String b = "2";
    private final static Map<Integer, Integer> map = Maps.newHashMap();

    static {
        map.put(1, 2);
        map.put(3, 4);
        map.put(5, 6);
    }

    public static void main(String[] args) {
//        a = 2;
//        b = "3";
//        map = Maps.newHashMap();   指向一个新的对象
        map.put(1, 3);               //引用的值就修改了，这时就引发了线程安全问题
        log.info("{}", map.get(1));
    }

    private void test(final int a) {
//        a = 1;
    }
}
