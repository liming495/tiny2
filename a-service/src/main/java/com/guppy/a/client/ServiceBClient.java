package com.guppy.a.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 服务B客户端接口
 *
 * @author Guppy
 */
@FeignClient(name = "b-service", fallback = ServiceBClient.ServiceBClientFallback.class)
public interface ServiceBClient {
    @GetMapping(value = "/")
    String printServiceB(@RequestParam(value = "age") String age);

    @Component
    class ServiceBClientFallback implements ServiceBClient {
        private static final Logger LOGGER = LoggerFactory.getLogger(ServiceBClientFallback.class);

        @Override
        public String printServiceB(String age) {
            LOGGER.info("异常发生，进入fallback方法 " + age);
            return "SERVICE B FAILED! - FALLING BACK";
        }
    }
}
