package com.guppy.d.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 服务D1客户端接口
 *
 * @author Guppy
 */
@FeignClient(name = "d1-service", fallback = ServiceD1Client.ServiceBClientFallback.class)
public interface ServiceD1Client {
    @GetMapping(value = "/")
    String printServiceD1();

    @Component
    class ServiceBClientFallback implements ServiceD1Client {
        private static final Logger LOGGER = LoggerFactory.getLogger(ServiceBClientFallback.class);

        @Override
        public String printServiceD1() {
            LOGGER.info("异常发生，进入fallback方法");
            return "SERVICE B FAILED! - FALLING BACK";
        }
    }
}
