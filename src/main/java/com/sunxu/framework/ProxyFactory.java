package com.sunxu.framework;

import com.sunxu.framework.protocol.http.HttpClient;
import com.sunxu.provider.api.HelloService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author 孙许
 * @version 1.0
 * @date 2021/3/1 22:38
 */
public class ProxyFactory {

    public static <T> T getProxy(Class interfaceClass) {

        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class[]{interfaceClass},
                (proxy, method, args) -> {
                    Invocation invocation = new Invocation(interfaceClass.getName(), method.getName(),
                            method.getParameterTypes(), args);
                    HttpClient httpClient = new HttpClient();
                    String result = httpClient.send("localhost", 8080, invocation);
                    return result;
                });
    }
}
