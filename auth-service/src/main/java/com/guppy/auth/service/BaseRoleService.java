package com.guppy.auth.service;

import com.guppy.auth.common.ResponseCode;
import com.guppy.data.mapper.model.BaseRole;
import com.guppy.data.vo.ResponseData;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * TODO
 *
 * @author Guppy
 */
public interface BaseRoleService extends BaseRoleRemoteService{

    class HystrixClientFallback implements BaseRoleService{

        @Override
        public ResponseData<List<BaseRole>> getRoleByUserId(@PathVariable("userId") String userId) {
            return new ResponseData<>(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getMessage());
        }
    }
}
