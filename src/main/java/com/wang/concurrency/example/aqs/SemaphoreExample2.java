package com.wang.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@Slf4j
public class SemaphoreExample2 {

    private static final int threadCount = 20;

    public static void main(String[] args) {

        ExecutorService exec = Executors.newCachedThreadPool();

        // 控制只有3个，而获取3个，此时相当于单线程
        final Semaphore semaphore = new Semaphore(3);

        for(int i = 0; i < threadCount; i++){
            final int threadNum = i;
            exec.execute(() -> {
                try {
                    semaphore.acquire(3);  //获取多个许可，
                    test(threadNum);
                    semaphore.release(3);
                }catch (Exception e){
                    log.error("exception", e);
                }
            });
        }
        exec.shutdown();
    }

    private static void test(int threadNum) throws  Exception{
        log.info("{}", threadNum);
        Thread.sleep(1000);    //每秒执行一次
    }
}
