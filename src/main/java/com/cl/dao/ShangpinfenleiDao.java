package com.cl.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.cl.entity.ShangpinfenleiEntity;
import com.cl.entity.view.ShangpinfenleiView;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 商品分类
 *
 * @author
 * @email
 * @date 2025-03-21 13:53:13
 */
public interface ShangpinfenleiDao extends BaseMapper<ShangpinfenleiEntity> {

    List<ShangpinfenleiView> selectListView(@Param("ew") Wrapper<ShangpinfenleiEntity> wrapper);

    List<ShangpinfenleiView> selectListView(Pagination page, @Param("ew") Wrapper<ShangpinfenleiEntity> wrapper);

    ShangpinfenleiView selectView(@Param("ew") Wrapper<ShangpinfenleiEntity> wrapper);


}
