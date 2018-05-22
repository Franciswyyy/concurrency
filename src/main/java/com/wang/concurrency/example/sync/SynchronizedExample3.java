package com.wang.concurrency.example.sync;

import lombok.extern.slf4j.Slf4j;

//锁非htis对象
@Slf4j
public class SynchronizedExample3 {
    public void Mehtod(Object obj){
        synchronized (obj){
            try{
                log.info("{} start time {}", Thread.currentThread().getName(), System.currentTimeMillis());
                Thread.sleep(1000);
                log.info("{} end time {}",  Thread.currentThread().getName(),System.currentTimeMillis());
            }catch (InterruptedException e){
                log.info("exception", e);
            }
        }
    }

    public static void main(String[] args) {
        Object obj1 = new Object();
        Object obj2 = new Object();
        SynchronizedExample3 syn = new SynchronizedExample3();
        new Thread(() -> {
            syn.Mehtod(obj1);
        }).start();

        new Thread(() -> {
            syn.Mehtod(obj2);
        }).start();
    }
}
