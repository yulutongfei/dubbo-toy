package com.sunxu.framework.protocol.http;

import com.alibaba.fastjson.JSONObject;
import com.sunxu.framework.Invocation;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * @author 孙许
 * @version 1.0
 * @date 2021/3/1 22:17
 */
public class HttpClient {

    public String send(String hostName, Integer port, Invocation invocation) throws Exception {
        // 读取用户的配置
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("http", null, hostName, port, "/", null, null))
                .POST(HttpRequest.BodyPublishers.ofString(JSONObject.toJSONString(invocation)))
                .build();

        java.net.http.HttpClient httpClient = java.net.http.HttpClient.newHttpClient();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}
