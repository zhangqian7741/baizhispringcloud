package com.baizhi.users9999.fallback;

import com.baizhi.users9999.clients.ProductClients;
import com.baizhi.users9999.entity.Product;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ProductClientFallBack
 * @Description ProductClientFallBack 管理类
 * @Author zhangqian
 * @Date 2020/8/25 0025 14:52
 */
@Component
public class ProductClientFallBack implements ProductClients {
    static Map<String, Object> result = new HashMap<>();

    static {
        result.put("status", false);
        result.put("msg", "当前服务已被降级");

    }

    @Override
    public String showMsg() {
        return "当前服务已被降级";
    }

    @Override
    public Map<String, Object> findOne(String productId) {
        return result;
    }

    @Override
    public Map<String, Object> save(String name) {
        return result;
    }

    @Override
    public Map<String, Object> update(Product product) {
        return result;
    }

    @Override
    public String testBreak(Integer id) {
        return "当前服务已被降级";
    }
}
