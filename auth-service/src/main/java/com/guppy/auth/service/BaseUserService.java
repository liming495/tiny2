package com.guppy.auth.service;

import com.guppy.auth.common.ResponseCode;
import com.guppy.auth.dao.entity.BaseUser;
import com.guppy.auth.dao.entity.BaseUserRole;
import com.guppy.auth.vo.ResponseData;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/**
 * TODO
 *
 * @author Guppy
 */
@Service
public class BaseUserService extends BaseService<BaseUser>{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BaseUserService baseUserService;
    @Autowired
    private BaseUserRoleService baseUserRoleService;


    /**
     * 批量重置密码
     * @param record
     * @param newPassword
     */
    @Transactional
    public void resetPassword(List<BaseUser> record, String newPassword) {
        record.forEach(e -> {
            BaseUser baseUser = new BaseUser();
            baseUser.setId(e.getId());
            baseUser.setPassword(new BCryptPasswordEncoder(6).encode(newPassword));
            baseUser.setUpdateDate(new Date());
            updateByPrimaryKeySelective(baseUser);
        });
    }

    /**
     * 删除用户
     * @param record
     */
    @Transactional
    public void deleteBatch(List<BaseUser> record) {
        record.forEach(e -> {
            Example example = new Example(BaseUserRole.class);
            example.createCriteria().andEqualTo("userId", e.getId());
            baseUserRoleService.deleteByExample(example);
            deleteByPrimaryKey(e);
        });
    }

    /**
     * 根据用户名获取用户信息
     * @param userName
     * @return
     */
    public ResponseData<BaseUser> getUserByUserName(@PathVariable("userName") String userName) {
        logger.debug("根据用户名查询用户");
        if(StringUtils.isEmpty(userName)){
            return new ResponseData<>(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getMessage());
        }
        BaseUser baseUser = new BaseUser();
        baseUser.setUserName(userName);
        baseUser = baseUserService.selectOne(baseUser);
        return new ResponseData<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage(), baseUser);
    }

    /**
     * 根据电话号码查询用户信息
     * @param phone
     * @return
     */
    public ResponseData<BaseUser> getUserByPhone(@PathVariable("phone") String phone) {
        logger.debug("根据电话号码查询用户");
        if(StringUtils.isEmpty(phone)){
            return new ResponseData<>(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getMessage());
        }
        BaseUser baseUser = new BaseUser();
        baseUser.setPhone(phone);
        baseUser = baseUserService.selectOne(baseUser);
        return new ResponseData<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage(), baseUser);
    }
}
