package com.guppy.a.controller;

import com.guppy.a.client.ServiceBClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

/**
 * 服务A控制器
 *
 * @author Guppy
 */
@RefreshScope
@RestController
public class ServiceAController {
    @Value("${name:unknown}")
    private String name;

    @Autowired
    private LoadBalancerClient client;
    @Autowired
    Registration registration;
    @Autowired
    ServiceBClient serviceBClient;

    @GetMapping(value = "/")
    public String printServiceA(){
        ServiceInstance serviceInstance = client.choose(registration.getServiceId());
        return serviceInstance.getServiceId()
                + " (" + serviceInstance.getHost()
                + ":"
                + serviceInstance.getPort()
                + ") ===>name:"
                + name
                + "<br/>"
                + serviceBClient.printServiceB("111");
    }

    @GetMapping(path = "/current")
    public Principal getCurrentAccount(Principal principal){  return principal; }
}
