package com.example.demo.controller;

import com.example.demo.config.ZkConfiguration;
import com.example.demo.dao.TestDao;
import com.example.demo.service.DemoTestService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: demo
 * @description:
 * @author: Mr.HuangDaDa
 * @create: 2022-07-26 11:02
 **/
@RestController
public class DemoTest {

    // zk节点
    private final static String PATH = "/zookeeper/lock";
    static Log log = LogFactory.getLog(ZkConfiguration.class);
    @Autowired
    ZkConfiguration zkConfiguration;

    @Autowired
    DemoTestService testDao;

    @GetMapping("/t1/{good_no}")
    public Map demo(@PathVariable("good_no") int good_no) {



        //创建公平锁
        InterProcessMutex lock = new InterProcessMutex(zkConfiguration.curatorFramework(), PATH);
        Map map = new ConcurrentHashMap();
        try {
            lock.acquire();
            Thread.sleep(new Random().nextInt(1000));

            Integer stock = testDao.getDataSource(good_no);
            if (stock == null || stock.intValue() <= 0) {
                map.put("msg","抢购失败,库存不足");
                return  map;
            }
            if (testDao.update(stock - 1, good_no)) {
                map.put("msg","抢购成功");
                return map;
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                lock.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        map.put("msg","抢购失败");
        return map;
    }
}
