package com.sunxu.framework;

import java.io.Serializable;

/**
 * @author 孙许
 * @version 1.0
 * @date 2021/3/1 22:55
 * 代表一个节点
 *
 */
public class URL implements Serializable {

    private String hostName;
    private Integer port;

    public URL(String hostName, Integer port) {
        this.hostName = hostName;
        this.port = port;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }
}
