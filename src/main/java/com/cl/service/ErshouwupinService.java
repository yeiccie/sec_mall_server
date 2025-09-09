package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.entity.ErshouwupinEntity;
import com.cl.entity.view.ErshouwupinView;
import com.cl.utils.PageUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * 二手物品
 *
 * @author
 * @email
 * @date 2025-03-21 13:53:13
 */
public interface ErshouwupinService extends IService<ErshouwupinEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<ErshouwupinView> selectListView(Wrapper<ErshouwupinEntity> wrapper);

    ErshouwupinView selectView(@Param("ew") Wrapper<ErshouwupinEntity> wrapper);

    PageUtils queryPage(Map<String, Object> params, Wrapper<ErshouwupinEntity> wrapper);


}

