package com.cl.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.cl.entity.DiscussershouwupinEntity;
import com.cl.entity.view.DiscussershouwupinView;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 二手物品评论表
 *
 * @author
 * @email
 * @date 2025-03-21 13:53:14
 */
public interface DiscussershouwupinDao extends BaseMapper<DiscussershouwupinEntity> {

    List<DiscussershouwupinView> selectListView(@Param("ew") Wrapper<DiscussershouwupinEntity> wrapper);

    List<DiscussershouwupinView> selectListView(Pagination page, @Param("ew") Wrapper<DiscussershouwupinEntity> wrapper);

    DiscussershouwupinView selectView(@Param("ew") Wrapper<DiscussershouwupinEntity> wrapper);


}
