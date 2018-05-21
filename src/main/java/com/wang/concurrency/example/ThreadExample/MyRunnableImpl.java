package com.wang.concurrency.example.ThreadExample;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.math.RandomUtils;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class MyRunnableImpl implements Callable{

    @Override
    public Integer call() throws Exception {
        Integer interval = RandomUtils.nextInt(1000);    //1000内的随机数
        Thread.sleep(interval);
        return interval;
    }

    public static void main(String[] args) throws Exception{
        //Future、Callable一般与Executor结合使用
        //Executor负责创建线程池服务
        //实现Callable接口形成的线程类，负责处理业务逻辑，并将处理结果返回
        //Future接口负责接收Callable接口返回的值
        ExecutorService exec = Executors.newFixedThreadPool(5);
        try {
            //定义一组返回值
            Future<Integer>[] futures = new Future[5];
            //向线程池提交任务
            for(int i = 0; i < 5; i ++){
                //注意Future的参数化类型要与Callable的参数化类型一致
                futures[i] = exec.submit(new MyRunnableImpl());
            }
            //输出结果
            for(int i = 0; i < 5; i ++){
                log.info("值为{}",futures[i].get());
            }
        }finally {
            exec.shutdown();
        }
    }
}
