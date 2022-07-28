package com.example.demo.service;

import com.example.demo.dao.TestDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoTestService {
    @Autowired
    TestDao testDao;

   public Boolean update(Integer quantity, Integer goods_no) {
        try {
            testDao.update(quantity, goods_no);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Integer getDataSource(Integer goods_no) {
        return testDao.getDataSource(goods_no);
    }

}
