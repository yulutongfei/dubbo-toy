package com.sunxu.framework.protocol.http;

import com.alibaba.fastjson.JSONObject;
import com.sunxu.framework.Invocation;
import com.sunxu.framework.register.LocalRegister;
import org.apache.commons.io.IOUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author 孙许
 * @version 1.0
 * @date 2021/2/28 13:13
 */
public class HttpServerHandler {

    public void handler(HttpServletRequest req, HttpServletResponse resp) {
        try {
            Invocation invocation = JSONObject.parseObject(req.getInputStream(), Invocation.class);
            // 如何根据接口名来获取具体的实现类呢? 采用localRegistry来实现
            String interfaceName = invocation.getInterfaceName();

            Class implClass = LocalRegister.get(interfaceName);
            Method method = implClass.getMethod(invocation.getMethodName(), invocation.getParamTypes());
            String result = (String) method.invoke(implClass.newInstance(), invocation.getParams());

            IOUtils.write(result, resp.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
