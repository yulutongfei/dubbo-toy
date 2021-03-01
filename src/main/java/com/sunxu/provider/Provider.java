package com.sunxu.provider;

import com.sunxu.framework.protocol.http.HttpServer;
import com.sunxu.framework.register.LocalRegister;
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
        HttpServer httpServer = new HttpServer();
        httpServer.start("localhost", 8080);
    }
}
