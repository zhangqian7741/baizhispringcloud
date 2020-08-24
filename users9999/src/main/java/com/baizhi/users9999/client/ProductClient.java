package com.baizhi.users9999.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("products")
public interface ProductClient {
    @GetMapping("/product/showMsg")
    public String showMsg();
}
