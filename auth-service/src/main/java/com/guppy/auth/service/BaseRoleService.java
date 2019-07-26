package com.guppy.auth.service;

import com.guppy.auth.dao.entity.BaseRole;
import com.guppy.auth.dao.mapper.BaseRoleMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO
 *
 * @author Guppy
 */
@Service
public class BaseRoleService extends BaseService<BaseRole>{

    /**
     * 根据用户查询角色
     * @param userId
     * @return
     */
    public List<BaseRole> getRoleByUserId(String userId) {
        return ((BaseRoleMapper)mapper).getRoleByUserId(userId);
    }
}
