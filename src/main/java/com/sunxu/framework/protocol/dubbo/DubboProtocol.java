package com.sunxu.framework.protocol.dubbo;

import com.sunxu.framework.Invocation;
import com.sunxu.framework.URL;
import com.sunxu.framework.protocol.Protocol;

/**
 * @author 孙许
 * @version 1.0
 * @date 2021/3/2 00:01
 */
public class DubboProtocol implements Protocol {

    @Override
    public void start(URL url) {

    }

    @Override
    public String send(URL url, Invocation invocation) {
        return null;
    }
}
