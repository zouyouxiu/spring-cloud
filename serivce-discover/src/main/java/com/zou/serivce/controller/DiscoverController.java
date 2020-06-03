package com.zou.serivce.controller;

import com.zou.serivce.conditional.Animal;
import com.zou.serivce.feign.RegisterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


/**
 * @ClassName DiscoverController
 * @Description TODO
 * @Author zouyouxiu
 * @Date 2019/12/17 10:17
 */
@RestController
public class DiscoverController {
    private static final Logger LOGGER = LoggerFactory.getLogger(DiscoverController.class);
    @Autowired
    RegisterService registerService;

    @Autowired
    private LoadBalancerClient loadbalancerclient;

    @Autowired
    RestTemplate restTemplate;



    @GetMapping("/testRibbon")
    public String testRibbon() {
        ServiceInstance serviceInstance = this.loadbalancerclient.choose("service-register");
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://service-register/test", String.class);
        DiscoverController.LOGGER.info("{}:{}:{}", serviceInstance.getServiceId(), serviceInstance.getHost(), serviceInstance.getPort());
        return forEntity.getBody();
    }

    @GetMapping("/test")
    public String test() {
        ServiceInstance serviceInstance = this.loadbalancerclient.choose("service-register");
        DiscoverController.LOGGER.info("{}:{}:{}", serviceInstance.getServiceId(), serviceInstance.getHost(), serviceInstance.getPort());
        return registerService.test();
    }

}
