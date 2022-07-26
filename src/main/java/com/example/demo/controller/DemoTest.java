package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: demo
 * @description:
 * @author: Mr.HuangDaDa
 * @create: 2022-07-26 11:02
 **/
@RestController
public class DemoTest {

    @GetMapping("/t1")
    public String demo(){

        return "test-sucess";
    }
}
