package com.baizhi.users9999.clients;

import com.baizhi.users9999.entity.Product;
import com.baizhi.users9999.fallback.ProductClientFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(value = "products",fallback = ProductClientFallBack.class)
public interface ProductClients {
    @GetMapping("product/showMsg")
    String showMsg();

    @GetMapping("/product/findOne")
    Map<String, Object> findOne(@RequestParam("productId") String productId);

    @PostMapping("/product/save")
    Map<String, Object> save(@RequestParam("name") String name);


    @PostMapping("/product/update")
    Map<String, Object> update(@RequestBody Product product);

    @GetMapping("/product/break")
    String testBreak(@RequestParam("id") Integer id);
    }
