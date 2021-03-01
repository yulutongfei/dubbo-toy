package com.sunxu.framework;

import com.sunxu.framework.protocol.Protocol;
import com.sunxu.framework.protocol.dubbo.DubboProtocol;
import com.sunxu.framework.protocol.http.HttpProtocol;
import org.apache.dubbo.common.utils.StringUtils;

/**
 * @author 孙许
 * @version 1.0
 * @date 2021/3/1 23:58
 * 工厂方法获取具体的protocol
 */
public class ProtocolFactory {

    /**
     * dubbo中真正用的动态生成类
     * @return
     */
    public static Protocol getProtocol() {
        String name = System.getProperty("protocolName");
        if (StringUtils.isBlank(name)) {
            name = "http";
        }
        if ("dubbo".equals(name)) {
            return new DubboProtocol();
        }
        return new HttpProtocol();
    }
}
