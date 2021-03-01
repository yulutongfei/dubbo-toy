package com.sunxu.framework;

import java.util.List;
import java.util.Random;

/**
 * @author 孙许
 * @version 1.0
 * @date 2021/3/1 23:05
 */
public class LoadBalance {

    public static URL random(List<URL> list) {
        Random random = new Random();
        int n = random.nextInt(list.size());
        return list.get(n);
    }
}
