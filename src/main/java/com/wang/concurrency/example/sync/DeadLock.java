package com.wang.concurrency.example.sync;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DeadLock {

    private static Object obj1 = new Object();
    private static Object obj2 = new Object();

    public static void main(String[] args) {

        new Thread(() -> {
            synchronized (obj1){
                log.info("thread1 get start lock1");
                try {
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    log.info("exception", e);
                }

                synchronized (obj2){
                    log.info("thread1 get start lock2");
                }
            }

            log.info("thread1 end");
        }).start();

        new Thread(() -> {
            synchronized (obj2){
                log.info("thread2 get start lock2");
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    log.info("exception", e);
                }

                synchronized (obj1){
                    log.info("thread2 get start lock1");
                }
            }
            log.info("thread2 end");
        }).start();
    }
}
