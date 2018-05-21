package com.wang.concurrency.example.ThreadExample;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JoinExample {

    public static void main(String[] args) throws InterruptedException{

        log.info("{} is start", Thread.currentThread().getName());

        Thread t0 = new Thread(() -> {
            try{
                log.info( "{} is Start,sleep 6 second", Thread.currentThread().getName());
                Thread.sleep(6000);
                log.info("{} is Completed", Thread.currentThread().getName());
            }catch (InterruptedException e){
                log.error("exception", e);
            }
        });
        t0.start();
        t0.join();

        Thread t1 = new Thread(() -> {
            try{
                log.info( "{} is Start,sleep 2 second", Thread.currentThread().getName());
                Thread.sleep(2000);
                log.info( "{} is Completed", Thread.currentThread().getName());
            }catch (InterruptedException e){
                log.error("exception", e);
            }
        });
        t1.start();
        t1.join();

        log.info("{} is Completed", Thread.currentThread().getName() );
    }
}
