package com.sunxu.provider.impl;

import com.sunxu.provider.api.HelloService;

/**
 * @author 孙许
 * @version 1.0
 * @date 2021/2/28 11:50
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String userName) {
        return "Hello: " + userName;
    }
}
