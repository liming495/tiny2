package com.guppy.auth.service;

import com.guppy.auth.common.ResponseCode;
import com.guppy.auth.mapper.model.BaseUser;
import com.guppy.auth.vo.ResponseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @author Guppy
 */
@Service
public class UsernameUserDetailServiceImpl extends BaseUserDetailServiceImpl implements UsernameUserDetailService{
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    protected BaseUser getUser(String username) {
        // 账号密码登陆调用FeignClient根据用户名查询用户
        ResponseData<BaseUser> baseUserResponseData = baseUserService.getUserByUserName(username);
        if(baseUserResponseData.getData() == null || !ResponseCode.SUCCESS.getCode().equals(baseUserResponseData.getCode())){
            logger.error("找不到该用户，用户名：" + username);
            throw new UsernameNotFoundException("找不到该用户，用户名：" + username);
        }
        return baseUserResponseData.getData();
    }
}