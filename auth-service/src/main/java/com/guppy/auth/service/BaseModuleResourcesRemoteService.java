package com.guppy.auth.service;

import com.guppy.data.mapper.model.BaseModuleResources;
import com.guppy.data.vo.ResponseData;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * TODO
 *
 * @author Guppy
 */
public interface BaseModuleResourcesRemoteService {

    /**
     * 根据userId查询菜单
     * @param userId
     * @return
     */
    @RequestMapping(value = "/menu/user/{userId}", method = RequestMethod.GET)
    ResponseData<List<BaseModuleResources>> getMenusByUserId(@PathVariable("userId") String userId);
}