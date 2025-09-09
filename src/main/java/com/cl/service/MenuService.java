package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.entity.MenuEntity;
import com.cl.entity.view.MenuView;
import com.cl.utils.PageUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * 菜单
 *
 * @author
 * @email
 * @date 2025-03-21 13:53:14
 */
public interface MenuService extends IService<MenuEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<MenuView> selectListView(Wrapper<MenuEntity> wrapper);

    MenuView selectView(@Param("ew") Wrapper<MenuEntity> wrapper);

    PageUtils queryPage(Map<String, Object> params, Wrapper<MenuEntity> wrapper);


}

