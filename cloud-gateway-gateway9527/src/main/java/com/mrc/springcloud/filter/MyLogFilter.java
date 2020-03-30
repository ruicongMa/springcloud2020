package com.mrc.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * @author Mark
 * @date 2020/3/30 14:45
 */
@Component
@Order
@Slf4j
public class MyLogFilter implements GlobalFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("**************全局过滤器 come in MyLogGateWayFilter: date:{}", new Date());
        String uname = exchange.getRequest().getQueryParams().getFirst("uname");
        if (StringUtils.isEmpty(uname)) {
            log.warn("********用户名为空，非法用户，o(╥﹏╥)o");
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

}
