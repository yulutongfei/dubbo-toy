package com.sunxu.framework.register;

import com.sunxu.framework.URL;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 孙许
 * @version 1.0
 * @date 2021/3/1 22:57
 */
public class RemoteMapRegister {

    private static Map<String, List<URL>> REGISTER = new HashMap<>();

    public static void register(String interfaceName, URL url) {
        Map<String, List<URL>> file = getFile();
        REGISTER = file;
        List<URL> list = REGISTER.get(interfaceName);
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(url);
        REGISTER.put(interfaceName, list);
        saveFile();
    }

    public static List<URL> get(String interfaceName) {
        REGISTER = getFile();

        List<URL> list = REGISTER.get(interfaceName);
        return list;
    }

    private static Map<String, List<URL>> getFile() {
        File file = new File("cache.txt");
        if (!file.exists()) {
            return new HashMap<>();
        }
        Object object = null;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {
            object = objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return (Map<String, List<URL>>) object;
    }

    private static void saveFile() {
        File file = new File("cache.txt");
        file.delete();
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            objectOutputStream.writeObject(REGISTER);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
