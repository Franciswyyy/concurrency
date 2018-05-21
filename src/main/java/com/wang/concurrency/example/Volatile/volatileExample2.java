package com.wang.concurrency.example.Volatile;

public class volatileExample2 {

    private volatile static boolean shutdown = false;

    static class CoffeeMaker{
        private static void shutdown(){
            shutdown = true;
            System.out.println("关闭了");
        }

        private static void makeCoffee(String name){
            System.out.println("开始了");
            System.out.println(name);
            while(!shutdown){
            }
            System.out.println("停止不服务");
        }
    }

    public static void main(String[] args)throws Exception{
        new Thread(() -> {
            CoffeeMaker.makeCoffee(Thread.currentThread().getName());
        }).start();
        Thread.sleep(1000);
        new Thread(() -> CoffeeMaker.shutdown()).start();
    }
}
