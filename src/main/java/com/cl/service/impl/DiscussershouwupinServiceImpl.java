package com.cl.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.dao.DiscussershouwupinDao;
import com.cl.entity.DiscussershouwupinEntity;
import com.cl.entity.view.DiscussershouwupinView;
import com.cl.service.DiscussershouwupinService;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("discussershouwupinService")
public class DiscussershouwupinServiceImpl extends ServiceImpl<DiscussershouwupinDao, DiscussershouwupinEntity> implements DiscussershouwupinService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussershouwupinEntity> page = this.selectPage(
                new Query<DiscussershouwupinEntity>(params).getPage(),
                new EntityWrapper<DiscussershouwupinEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussershouwupinEntity> wrapper) {
        Page<DiscussershouwupinView> page = new Query<DiscussershouwupinView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page, wrapper));
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }

    @Override
    public List<DiscussershouwupinView> selectListView(Wrapper<DiscussershouwupinEntity> wrapper) {
        return baseMapper.selectListView(wrapper);
    }

    @Override
    public DiscussershouwupinView selectView(Wrapper<DiscussershouwupinEntity> wrapper) {
        return baseMapper.selectView(wrapper);
    }


}
