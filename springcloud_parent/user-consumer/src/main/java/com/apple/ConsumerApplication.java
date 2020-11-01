package com.apple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author pengmin
 * @date 2020/10/29 17:41
 */
@SpringBootApplication
// 开启eureka客户端;
@EnableDiscoveryClient
// 开启熔断
@EnableCircuitBreaker
@EnableFeignClients
public class ConsumerApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ConsumerApplication.class, args);
       /* Object mappingTest = context.getBean("userFeign");
        System.out.println(mappingTest);*/
    }

    // IOC将restTemplate对象交给spring容器管理;
    @Bean
    // 开启负载均衡;
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
