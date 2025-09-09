package com.cl.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.cl.entity.ErshouwupinEntity;
import com.cl.entity.view.ErshouwupinView;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 二手物品
 *
 * @author
 * @email
 * @date 2025-03-21 13:53:13
 */
public interface ErshouwupinDao extends BaseMapper<ErshouwupinEntity> {

    List<ErshouwupinView> selectListView(@Param("ew") Wrapper<ErshouwupinEntity> wrapper);

    List<ErshouwupinView> selectListView(Pagination page, @Param("ew") Wrapper<ErshouwupinEntity> wrapper);

    ErshouwupinView selectView(@Param("ew") Wrapper<ErshouwupinEntity> wrapper);


}
