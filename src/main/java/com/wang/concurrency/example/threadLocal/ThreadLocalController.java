package com.wang.concurrency.example.threadLocal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/threadLocal")
public class ThreadLocalController {

    @RequestMapping("/test")
    @ResponseBody
    public Long test() {
        return RequestHolder.getId();
    }
}

//测试，成功拿到了   发送请求，通过filter，在拦截器 放数据到threadlocal，处理完后，输出完，通过interceptor移除数据，避免数据泄露。
// 在处理时，实时可以取threadlocal， 其中SpringMVC ，Springboot之类配置filter，mvc，interceptor的、


