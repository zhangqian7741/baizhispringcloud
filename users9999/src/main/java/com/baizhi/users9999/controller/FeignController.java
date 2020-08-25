package com.baizhi.users9999.controller;

import com.baizhi.users9999.client.ProductClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class FeignController {
    @Autowired
    private ProductClient productClient;

    @GetMapping("/feign/test")
    public String test() {
        log.info("进入调用feign测试方法....");
        return productClient.showMsg();
    }
}
