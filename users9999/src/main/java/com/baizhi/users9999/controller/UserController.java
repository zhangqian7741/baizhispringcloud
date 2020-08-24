package com.baizhi.users9999.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @ClassName UserController
 * @Description UserController 管理类
 * @Author zhangqian
 * @Date 2020/8/24 0024 16:27
 */
@RestController
@Slf4j
public class UserController {

@Autowired
private DiscoveryClient discoveryClient;

@Autowired
private RestTemplate restTemplate;
    @GetMapping("/user/showMsg")
    public String showMsg(){
        String msg = restTemplate.getForObject("http://localhost:9998/product/showMsg", String.class);
        return msg;
    }

    @GetMapping("/user/findAllProducts")
    public String findAllProducts(){
//        RestTemplate restTemplate = new RestTemplate();
//        String msg = restTemplate.getForObject("http://localhost:9998/products/findAll", String.class);

//        List<ServiceInstance> products = discoveryClient.getInstances("products");

        String msg = restTemplate.getForObject("http://products/product/findAll", String.class);
        return msg;
    }
}
