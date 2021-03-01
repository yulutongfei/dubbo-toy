package com.sunxu.provider;

import com.sunxu.framework.ProtocolFactory;
import com.sunxu.framework.URL;
import com.sunxu.framework.protocol.Protocol;
import com.sunxu.framework.protocol.http.HttpProtocol;
import com.sunxu.framework.protocol.http.HttpServer;
import com.sunxu.framework.register.LocalRegister;
import com.sunxu.framework.register.RemoteMapRegister;
import com.sunxu.provider.api.HelloService;
import com.sunxu.provider.impl.HelloServiceImpl;

/**
 * @author 孙许
 * @version 1.0
 * @date 2021/2/28 11:47
 */
public class Provider {

    public static void main(String[] args) {
        // key也可以添加服务的版本号
        LocalRegister.register(HelloService.class.getName(), HelloServiceImpl.class);

        // 注册中心注册
        URL url = new URL("localhost", Integer.valueOf(args[0]));
        RemoteMapRegister.register(HelloService.class.getName(), url);

        // 启动tomcat/netty
//        HttpServer httpServer = new HttpServer();
//        httpServer.start(url.getHostName(), url.getPort());

        Protocol protocol = ProtocolFactory.getProtocol();
        protocol.start(url);
    }
}
