package com.guppy.auth.service;

import com.guppy.data.mapper.model.BaseUser;
import com.guppy.data.vo.ResponseData;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * TODO
 *
 * @author Guppy
 */
public interface BaseUserRemoteService {
    /**
     * 根据用户名查询用户
     * @param userName
     * @return
     */
    @RequestMapping(value = "/user/name/{userName}", method = RequestMethod.GET)
    ResponseData<BaseUser> getUserByUserName(@PathVariable("userName") String userName);

    /**
     * 根据电话号码查询用户
     * @param phone
     * @return
     */
    @RequestMapping(value = "/user/phone/{phone}", method = RequestMethod.GET)
    ResponseData<BaseUser> getUserByPhone(@PathVariable("phone") String phone);
}
