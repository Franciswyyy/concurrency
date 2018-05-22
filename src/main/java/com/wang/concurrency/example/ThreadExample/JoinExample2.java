package com.wang.concurrency.example.ThreadExample;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class JoinExample2 {

    public static void main(String[] args) {

        final Thread t1 = new Thread(() -> {
            log.info("{}, the first 运行了！", Thread.currentThread().getName());
        },"线程1");


        final Thread t2 = new Thread(() -> {
            log.info("{}, the second 运行了！", Thread.currentThread().getName());
        }, "线程2");

        final Thread t3 = new Thread(() -> {
            log.info("{}, the third 运行了！", Thread.currentThread().getName());
        }, "线程3");

        ExecutorService exec = Executors.newSingleThreadExecutor();
        exec.submit(t1);
        exec.submit(t2);
        exec.submit(t3);
        exec.shutdown();
    }
}
