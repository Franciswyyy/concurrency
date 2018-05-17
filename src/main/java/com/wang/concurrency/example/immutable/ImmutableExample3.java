package com.wang.concurrency.example.immutable;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.wang.concurrency.annoations.ThreadSafe;


@ThreadSafe
public class ImmutableExample3 {

    //经过immutable创建的之后就不能使用add ，put方法了

    private final static ImmutableList<Integer> list = ImmutableList.of(1, 2, 3);

    private final static ImmutableSet set = ImmutableSet.copyOf(list);

    private final static ImmutableMap<Integer, Integer> map = ImmutableMap.of(1, 2, 3, 4);

    private final static ImmutableMap<Integer, Integer> map2 = ImmutableMap.<Integer, Integer>builder()
            .put(1, 2).put(3, 4).put(5, 6).build();


    public static void main(String[] args) {
        //list = ImmutableList.of(1,2,3,4);   加final的意义在于创建的list不能指向其他不可变list，而immutable的作用是里面的数据不能变
        System.out.println(map2.get(3));
    }
}
