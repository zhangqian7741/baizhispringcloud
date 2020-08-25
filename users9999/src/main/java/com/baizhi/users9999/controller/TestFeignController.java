package com.baizhi.users9999.controller;

import com.baizhi.users9999.clients.ProductClients;
import com.baizhi.users9999.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @ClassName TestFeignController
 * @Description TestFeignController 管理类
 * @Author zhangqian
 * @Date 2020/8/25 0025 9:54
 */
@Slf4j
@RestController
public class TestFeignController {

    @Autowired
    private ProductClients productClients;

//    @GetMapping("feign/test")
//    public String test() {
//        log.info("进入feign 测试调用方法");
//        return productClients.showMsg();
//    }

    @GetMapping("feign/test1")
    public Map<String, Object> test1(@RequestParam("productId") String productId) {
        log.info("进入feign 测试调用方法");
        return productClients.findOne(productId);
    }

    @PostMapping("feign/test2")
    public Map<String, Object> test2(@RequestParam("name") String name) {
        log.info("进入feign 测试调用方法");
        return productClients.save(name);
    }


    @PostMapping("feign/test3")
    public Map<String, Object> test3(@RequestBody Product product) {
        log.info("进入feign 测试调用方法");
        return productClients.update(product);
    }

}
