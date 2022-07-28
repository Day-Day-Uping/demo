package com.example.demo.config;

import com.example.demo.entity.WrapperZk;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 初始化Curator ZK配置类
 */
@Configuration
public class ZkConfiguration {
    static Log log = LogFactory.getLog(ZkConfiguration.class);
    @Autowired
    WrapperZk wrapperZk;

    @Bean(initMethod = "start") // 初始化的时候调用CuratorFramework的start方法
    public CuratorFramework curatorFramework() {
        // 重试策略
        RetryPolicy retrYPolicy = new ExponentialBackoffRetry(wrapperZk.getBaseSleepTimeMs(), wrapperZk.getRetryCount());
        // zk地址
        CuratorFramework client = CuratorFrameworkFactory.newClient(wrapperZk.getConnectString(), retrYPolicy);
        log.info("zk curator初始化完成...");
        return client;
    }
}