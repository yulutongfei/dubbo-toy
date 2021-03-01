package com.sunxu.framework.register;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 孙许
 * @version 1.0
 * @date 2021/2/28 13:41
 */
public class LocalRegister {

    private static Map<String, Class> map = new HashMap<>();

    public static void register(String interfaceName, Class implClass) {
        map.put(interfaceName, implClass);
    }

    public static Class get(String interfaceName) {
        return map.get(interfaceName);
    }
}
