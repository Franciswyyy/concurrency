package com.wang.concurrency.example.Volatile;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class volatileExample {

    private static boolean isRunning = true;

    private static void shutdown(){
        isRunning = false;
        System.out.println("关闭了");
    }

    private static void isStart(String name){
        System.out.println("start...");
        System.out.println(name);
        while(isRunning){}
        System.out.println("end...");
    }


    public static void main(String[] args) throws InterruptedException{
        new Thread(() -> {
            isStart(Thread.currentThread().getName());
        }).start();

        Thread.sleep(100);

        new Thread(() -> shutdown()).start();
    }
}

