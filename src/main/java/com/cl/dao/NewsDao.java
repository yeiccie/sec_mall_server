package com.cl.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.cl.entity.NewsEntity;
import com.cl.entity.view.NewsView;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 系统公告
 *
 * @author
 * @email
 * @date 2025-03-21 13:53:14
 */
public interface NewsDao extends BaseMapper<NewsEntity> {

    List<NewsView> selectListView(@Param("ew") Wrapper<NewsEntity> wrapper);

    List<NewsView> selectListView(Pagination page, @Param("ew") Wrapper<NewsEntity> wrapper);

    NewsView selectView(@Param("ew") Wrapper<NewsEntity> wrapper);


}
