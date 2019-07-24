package com.guppy.data.client;

import com.guppy.data.mapper.model.BaseUser;
import com.guppy.data.vo.ResponseCode;
import com.guppy.data.vo.ResponseData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * TODO
 *
 * @author Guppy
 */
@FeignClient(name = InterfaceService.SERVICE_NAME, fallback = BaseUserService.HystrixClientFallback.class)
public interface BaseUserService extends BaseUserRemoteService {

    class HystrixClientFallback implements BaseUserService{

        @Override
        public ResponseData<BaseUser> getUserByUserName(@PathVariable("userName") String userName) {
            return new ResponseData<>(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getMessage());
        }

        @Override
        public ResponseData<BaseUser> getUserByPhone(@PathVariable("phone") String phone) {
            return new ResponseData<>(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getMessage());
        }
    }
}
