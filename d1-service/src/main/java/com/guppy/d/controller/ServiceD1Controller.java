package com.guppy.d.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
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
    EurekaDiscoveryClient discoveryClient;
    @Autowired
    Registration registration;

    @GetMapping(value = "/")
    public String printServiceD1(){
        ServiceInstance serviceInstance = serviceInstance();
        return serviceInstance.getServiceId()
                + " ("
                + serviceInstance.getHost()
                + ":"
                + serviceInstance.getPort()
                + ")"
                + "===>Say "
                + msg;
    }

    public ServiceInstance serviceInstance() {
        List<ServiceInstance> list = discoveryClient.getInstances(registration.getServiceId());
        if (list != null && list.size() > 0) {
            for(ServiceInstance itm : list){
                if(itm.getPort() == 2001)
                    return itm;
            }
        }
        return null;
    }
}
