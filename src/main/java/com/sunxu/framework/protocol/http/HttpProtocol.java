package com.sunxu.framework.protocol.http;

import com.sunxu.framework.Invocation;
import com.sunxu.framework.URL;
import com.sunxu.framework.protocol.Protocol;

/**
 * @author 孙许
 * @version 1.0
 * @date 2021/3/1 23:53
 */
public class HttpProtocol implements Protocol {

    @Override
    public void start(URL url) {
        HttpServer httpServer = new HttpServer();
        httpServer.start(url.getHostName(), url.getPort());
    }

    @Override
    public String send(URL url, Invocation invocation) {
        return new HttpClient().send(url.getHostName(), url.getPort(), invocation);
    }
}
