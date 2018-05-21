package com.wang.concurrency.example.ThreadExample;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JoinExample1 {

    public static void main(String[] args) {
        final Thread t1 = new Thread(() -> {
            log.info("{} is first", Thread.currentThread().getName());
        },"线程1");

        final Thread t2 = new Thread(() -> {
            try {
                t1.join();
                log.info("{} is second", Thread.currentThread().getName());
            }catch (InterruptedException e){
                log.info("exception", e);
            }
        },"线程2");

        final Thread t3 = new Thread(() -> {
            try {
                t2.join();
                log.info("{} is third", Thread.currentThread().getName());
            }catch (InterruptedException e){
                log.info("exception", e);
            }
        },"线程3");

        t2.start();
        t3.start();
        t1.start();


    }
}
