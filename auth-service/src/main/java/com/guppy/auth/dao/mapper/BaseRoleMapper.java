package com.guppy.auth.dao.mapper;

import com.guppy.auth.dao.entity.BaseRole;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * TODO
 *
 * @author Guppy
 */
@org.apache.ibatis.annotations.Mapper
public interface BaseRoleMapper extends Mapper<BaseRole> {
    List<BaseRole> getRoleByUserId(@Param("userId") String userId);
}
