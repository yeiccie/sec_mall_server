package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.entity.DiscussershouwupinEntity;
import com.cl.entity.view.DiscussershouwupinView;
import com.cl.utils.PageUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * 二手物品评论表
 *
 * @author
 * @email
 * @date 2025-03-21 13:53:14
 */
public interface DiscussershouwupinService extends IService<DiscussershouwupinEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<DiscussershouwupinView> selectListView(Wrapper<DiscussershouwupinEntity> wrapper);

    DiscussershouwupinView selectView(@Param("ew") Wrapper<DiscussershouwupinEntity> wrapper);

    PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussershouwupinEntity> wrapper);


}

