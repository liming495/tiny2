package com.guppy.d.controller;

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
 * 服务D1控制器
 *
 * @author Guppy
 */
@RefreshScope
@RestController
public class ServiceD1Controller {
    @Value(value = "${msg:unknown}")
    private String msg;

    @Autowired
    private LoadBalancerClient client;
    @Autowired
    Registration registration;

    @GetMapping(value = "/")
    public String printServiceD1(){
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
