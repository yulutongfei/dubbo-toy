package com.sunxu.framework;

import com.sunxu.framework.protocol.Protocol;
import com.sunxu.framework.protocol.http.HttpClient;
import com.sunxu.framework.protocol.http.HttpProtocol;
import com.sunxu.framework.register.RemoteMapRegister;
import com.sunxu.provider.api.HelloService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

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

                    // mock数据代码
                    try {
                        Protocol protocol = ProtocolFactory.getProtocol();
                        List<URL> urlList = RemoteMapRegister.get(interfaceClass.getName());
                        // 负载均衡获取具体的节点
                        URL url = LoadBalance.random(urlList);
                        String result = protocol.send(url, invocation);
                        return result;
                    } catch (Exception e) {
                        // 容错代码
                        return "容错逻辑";
                    }
                });
    }
}
