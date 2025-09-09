package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.entity.ShangpinfenleiEntity;
import com.cl.entity.view.ShangpinfenleiView;
import com.cl.utils.PageUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * 商品分类
 *
 * @author
 * @email
 * @date 2025-03-21 13:53:13
 */
public interface ShangpinfenleiService extends IService<ShangpinfenleiEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<ShangpinfenleiView> selectListView(Wrapper<ShangpinfenleiEntity> wrapper);

    ShangpinfenleiView selectView(@Param("ew") Wrapper<ShangpinfenleiEntity> wrapper);

    PageUtils queryPage(Map<String, Object> params, Wrapper<ShangpinfenleiEntity> wrapper);


}

