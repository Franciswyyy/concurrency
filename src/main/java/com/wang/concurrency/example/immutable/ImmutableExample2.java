package com.wang.concurrency.example.immutable;

import com.google.common.collect.Maps;

import com.wang.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.Map;

@Slf4j
@ThreadSafe
public class ImmutableExample2 {

    private static Map<Integer, Integer> map = Maps.newHashMap();

    static {
        map.put(1, 2);
        map.put(3, 4);
        map.put(5, 6);
        map = Collections.unmodifiableMap(map);  //初始化之后就不能修改了，不允许修改的map
    }

    public static void main(String[] args) {
        map.put(1, 3);               //不能再被修改了，会抛出异常
        log.info("{}", map.get(1));
    }

}
