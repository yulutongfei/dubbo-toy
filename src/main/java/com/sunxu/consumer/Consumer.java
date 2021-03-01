package com.sunxu.consumer;


import com.sunxu.framework.Invocation;
import com.sunxu.framework.ProxyFactory;
import com.sunxu.framework.protocol.http.HttpClient;
import com.sunxu.provider.api.HelloService;

/**
 * @author 孙许
 * @version 1.0
 * @date 2021/2/28 11:47
 */
public class Consumer {

    public static void main(String[] args) {

        HelloService helloService = ProxyFactory.getProxy(HelloService.class);
        String result = helloService.sayHello("孙许好噻");
        System.out.println(result);
    }
}
