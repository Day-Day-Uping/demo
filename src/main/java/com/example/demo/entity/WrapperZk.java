package com.example.demo.entity;



import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @program: demo
 * @description:zk配置文件实体类
 * @author: Mr.HuangDaDa
 * @create: 2022-07-27 17:13
 **/
@Component
@ConfigurationProperties(prefix = "curator")
public class WrapperZk {

    /** 重试次数 */
    private int retryCount;

    /** 过期时间 */
    private int elapsedTimeMs;

    /** zk单\集群地址 */
    private String connectString;

    /** session超时时间 */
    private int sessionTimeoutMs;

    /** 连接超时时间 */
    private int connectionTimeoutMs;

    /** 睡眠时间 */
    private int baseSleepTimeMs;

    public int getRetryCount() {
        return retryCount;
    }

    public void setRetryCount(int retryCount) {
        this.retryCount = retryCount;
    }

    public int getElapsedTimeMs() {
        return elapsedTimeMs;
    }

    public void setElapsedTimeMs(int elapsedTimeMs) {
        this.elapsedTimeMs = elapsedTimeMs;
    }

    public String getConnectString() {
        return connectString;
    }

    public void setConnectString(String connectString) {
        this.connectString = connectString;
    }

    public int getSessionTimeoutMs() {
        return sessionTimeoutMs;
    }

    public void setSessionTimeoutMs(int sessionTimeoutMs) {
        this.sessionTimeoutMs = sessionTimeoutMs;
    }

    public int getConnectionTimeoutMs() {
        return connectionTimeoutMs;
    }

    public void setConnectionTimeoutMs(int connectionTimeoutMs) {
        this.connectionTimeoutMs = connectionTimeoutMs;
    }

    public int getBaseSleepTimeMs() {
        return baseSleepTimeMs;
    }

    public void setBaseSleepTimeMs(int baseSleepTimeMs) {
        this.baseSleepTimeMs = baseSleepTimeMs;
    }
}