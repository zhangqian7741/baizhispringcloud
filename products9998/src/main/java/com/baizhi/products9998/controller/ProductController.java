package com.baizhi.products9998.controller;

import com.baizhi.products9998.entity.Product;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

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
    public String showMsg() {
        log.info("进入商品服务,展示商品信息...");
        return "进入商品服务,展示商品信息..." + " 当前服务的端口为" + port;

    }

    @GetMapping("/product/findAll")
    public Map<String, Object> findAll() {
        Map<String, Object> map = new HashMap<>();
        log.info("进入商品服务,展示商品信息...");
        map.put("status", true);
        map.put("msg", "查询所有商品成功,当前服务端口:" + port);
        return map;
    }

    @GetMapping("/product/findOne")
    public Map<String, Object> findOne(String productId) {

        Map<String, Object> map = new HashMap<>();
        map.put("status", true);
        map.put("msg", "根据商品id查询商品成功");
        map.put("productId", productId);
        return map;
    }

    @PostMapping("/product/save")
    public Map<String, Object> save(String name) {

        Map<String, Object> map = new HashMap<>();
        map.put("status", true);
        map.put("msg", "根据商品name查询商品成功");
        map.put("name", name);
        return map;
    }

    @PostMapping("/product/update")
    public Map<String, Object> update(@RequestBody Product product) {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Map<String, Object> map = new HashMap<>();
        map.put("status", true);
        map.put("msg", "根据商品name查询商品成功");
        map.put("product", product);
        return map;
    }


    @GetMapping("product/break")
//    @HystrixCommand(fallbackMethod = "testBreakFallBack")
    public String testBreak(Integer id) {
        if (id < 0)
            throw new RuntimeException("非法参数,id < 0 ");

        return "访问成功当前访问的id:  " + id;
    }


}
