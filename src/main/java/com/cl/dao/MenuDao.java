package com.cl.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.cl.entity.MenuEntity;
import com.cl.entity.view.MenuView;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 菜单
 *
 * @author
 * @email
 * @date 2025-03-21 13:53:14
 */
public interface MenuDao extends BaseMapper<MenuEntity> {

    List<MenuView> selectListView(@Param("ew") Wrapper<MenuEntity> wrapper);

    List<MenuView> selectListView(Pagination page, @Param("ew") Wrapper<MenuEntity> wrapper);

    MenuView selectView(@Param("ew") Wrapper<MenuEntity> wrapper);


}
