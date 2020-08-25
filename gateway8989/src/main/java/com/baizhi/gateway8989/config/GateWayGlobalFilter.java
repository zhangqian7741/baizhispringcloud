package com.baizhi.gateway8989.config;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @ClassName GateWayGloblFilter
 * @Description GateWayGloblFilter 管理类
 * @Author zhangqian
 * @Date 2020/8/25 0025 17:22
 */
@Order(-1)
@Configuration
public class GateWayGlobalFilter implements GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        List<String> id = exchange.getRequest().getQueryParams().get("id");

        if (id == null) {
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }
}
