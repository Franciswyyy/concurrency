package com.wang.concurrency.example.threadLocal;

public class RequestHolder {

    //传入，提取，移除
    //什么时候添加  实际处理把相关信息写进去，这时就是filter，把相关信息写进去，url实际被处理就可以取信息了
    //remove在接口处理完之后，intercept
    private final static ThreadLocal<Long> requestHolder = new ThreadLocal<>();   //long就代表用户

    //只传入了一个，但是默认取出当前线程的id，放入线程的地址，而value则是这个id。
    public static void add(Long id){
        requestHolder.set(id);
    }

    public static Long getId(){
        return requestHolder.get();
    }

    public static void remove(){
        requestHolder.remove();
    }
}
