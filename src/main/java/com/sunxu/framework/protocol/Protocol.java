package com.sunxu.framework.protocol;

import com.sunxu.framework.Invocation;
import com.sunxu.framework.URL;

/**
 * @author 孙许
 * @version 1.0
 * @date 2021/3/1 23:53
 */
public interface Protocol {

    void start(URL url);

    String send(URL url, Invocation invocation);
}
