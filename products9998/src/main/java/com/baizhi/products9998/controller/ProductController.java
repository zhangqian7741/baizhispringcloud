package com.baizhi.products9998.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ProductController
 * @Description ProductController 管理类
 * @Author zhangqian
 * @Date 2020/8/24 0024 15:11
 */
@RestController
@Slf4j
public class ProductController {

    @Value("${server.port}")
    private Integer port;
    @GetMapping("/product/showMsg")
    public String showMsg(){
        log.info("进入商品服务,展示商品信息...");
        return "进入商品服务,展示商品信息..." + " 当前服务的端口为" + port;

    }

    @GetMapping("/product/findAll")
    public Map<String, Object> findAll(){
        Map<String,Object> map = new HashMap<>();
        log.info("进入商品服务,展示商品信息...");
        map.put("status",true);
        map.put("msg","查询所有商品成功,当前服务端口:" + port);
        return map;
    }
}
