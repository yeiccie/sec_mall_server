package com.cl.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.cl.entity.CartEntity;
import com.cl.entity.view.CartView;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 购物车
 *
 * @author
 * @email
 * @date 2025-03-21 13:53:13
 */
public interface CartDao extends BaseMapper<CartEntity> {

    List<CartView> selectListView(@Param("ew") Wrapper<CartEntity> wrapper);

    List<CartView> selectListView(Pagination page, @Param("ew") Wrapper<CartEntity> wrapper);

    CartView selectView(@Param("ew") Wrapper<CartEntity> wrapper);


}
