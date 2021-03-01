package com.sunxu.consumer;


import com.sunxu.framework.Invocation;
import com.sunxu.framework.protocol.http.HttpClient;
import com.sunxu.provider.api.HelloService;

/**
 * @author 孙许
 * @version 1.0
 * @date 2021/2/28 11:47
 */
public class Consumer {

    public static void main(String[] args) throws Exception {

        Invocation invocation = new Invocation(HelloService.class.getName(), "sayHello",
                new Class[]{String.class}, new Object[]{"孙许"});
        HttpClient httpClient = new HttpClient();
        String result = httpClient.send("localhost", 8080, invocation);
        System.out.println(result);
    }
}
