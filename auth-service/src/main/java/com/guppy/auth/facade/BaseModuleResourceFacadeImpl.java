package com.guppy.auth.facade;

import com.guppy.auth.common.ResponseCode;
import com.guppy.auth.dao.entity.BaseModuleResources;
import com.guppy.auth.service.BaseModuleResourceService;
import com.guppy.auth.vo.ResponseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * TODO
 *
 * @author Guppy
 */
@Component
public class BaseModuleResourceFacadeImpl {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BaseModuleResourceService baseModuleResourceService;

    public ResponseData<List<BaseModuleResources>> getMenusByUserId(@PathVariable("userId") String userId) {
        logger.debug("根据用户查询菜单");
        List<BaseModuleResources> list;
        try {
            list = baseModuleResourceService.getMenusByUserId(userId);
        }catch (Exception e){
            logger.error("根据用户查询菜单错误");
            e.printStackTrace();
            return new ResponseData<>(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getMessage());
        }
        return new ResponseData<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage(), list);
    }
}
