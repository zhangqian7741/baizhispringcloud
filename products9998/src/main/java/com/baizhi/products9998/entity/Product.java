package com.baizhi.products9998.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @ClassName Product
 * @Description Product 管理类
 * @Author zhangqian
 * @Date 2020/8/25 0025 13:13
 */
@Data
public class Product {
    private Integer id;
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date bir;
}
