package com.cl.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.dao.ErshouwupinDao;
import com.cl.entity.ErshouwupinEntity;
import com.cl.entity.view.ErshouwupinView;
import com.cl.service.ErshouwupinService;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("ershouwupinService")
public class ErshouwupinServiceImpl extends ServiceImpl<ErshouwupinDao, ErshouwupinEntity> implements ErshouwupinService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ErshouwupinEntity> page = this.selectPage(
                new Query<ErshouwupinEntity>(params).getPage(),
                new EntityWrapper<ErshouwupinEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<ErshouwupinEntity> wrapper) {
        Page<ErshouwupinView> page = new Query<ErshouwupinView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page, wrapper));
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }

    @Override
    public List<ErshouwupinView> selectListView(Wrapper<ErshouwupinEntity> wrapper) {
        return baseMapper.selectListView(wrapper);
    }

    @Override
    public ErshouwupinView selectView(Wrapper<ErshouwupinEntity> wrapper) {
        return baseMapper.selectView(wrapper);
    }


}
