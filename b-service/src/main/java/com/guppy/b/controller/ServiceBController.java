package com.guppy.b.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 服务B控制器
 *
 * @author Guppy
 */
@RefreshScope
@RestController
public class ServiceBController {
    @Autowired
    private LoadBalancerClient client;
    @Autowired
    private Registration registration; // 服务注册

    @Value(value = "${msg:unknown}")
    private String msg;

    @GetMapping(value = "/")
    public String printServiceB(){
        ServiceInstance serviceInstance = client.choose(registration.getServiceId());
        return serviceInstance.getServiceId()
                + " ("
                + serviceInstance.getHost()
                + ":"
                + serviceInstance.getPort()
                + ")"
                + "===>Say "
                + msg;
    }
}
