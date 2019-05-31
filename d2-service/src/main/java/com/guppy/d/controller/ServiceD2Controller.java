package com.guppy.d.controller;

import com.guppy.d.client.ServiceBClient;
import com.guppy.d.client.ServiceD1Client;
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
 * 服务D2控制器
 *
 * @author Guppy
 */
@RefreshScope
@RestController
public class ServiceD2Controller {
    @Value(value = "${name:unknown}")
    private String name;
    @Autowired
    EurekaDiscoveryClient discoveryClient;
    @Autowired
    ServiceD1Client serviceD1Client;
    @Autowired
    ServiceBClient serviceBClient;
    @Autowired
    Registration registration;

    @GetMapping(value = "/")
    public String printServiceA(){
        ServiceInstance serviceInstance = serviceInstance();
        return serviceInstance.getServiceId()
                + " (" + serviceInstance.getHost()
                + ":"
                + serviceInstance.getPort()
                + ") ===>name:"
                + name
                + "<br/>"
                + serviceD1Client.printServiceD1()
                + "<br/>"
                + serviceBClient.printServiceB();
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
