package com.apple.controller;

import com.apple.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author pengmin
 * @date 2020/10/29 17:44
 */
@RestController
@RequestMapping("/consumer")
@DefaultProperties(defaultFallback = "fallBack")
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;


    //@HystrixCommand(fallbackMethod = "fallBack")
    @GetMapping("/{id}")
    public User getUser(@PathVariable(value = "id")Integer id){
       /* User user = restTemplate.getForObject("http://localhost:8081/user/findById/"+id, User.class);
        return user;
        List<ServiceInstance> instances = discoveryClient.getInstances("user-provider");
        ServiceInstance serviceInstance = instances.get(0);
        String host = serviceInstance.getHost();
        int port = serviceInstance.getPort();*/
        User user = restTemplate.getForObject("http://user-provider/user/findById/" + id, User.class);
        return user;
    }

    public User fallBack(Integer id){
        User user = new User();
        user.setUsername("服务降级,自动处理");
        return user;
    }
}
