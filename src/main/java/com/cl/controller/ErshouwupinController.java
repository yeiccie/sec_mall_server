package com.cl.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.cl.annotation.IgnoreAuth;
import com.cl.entity.ErshouwupinEntity;
import com.cl.entity.view.ErshouwupinView;
import com.cl.service.ErshouwupinService;
import com.cl.service.StoreupService;
import com.cl.utils.MPUtil;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 二手物品
 * 后端接口
 *
 * @author
 * @email
 * @date 2025-03-21 13:53:13
 */
@RestController
@RequestMapping("/ershouwupin")
public class ErshouwupinController {
    @Autowired
    private ErshouwupinService ershouwupinService;
    @Autowired
    private StoreupService storeupService;

    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, ErshouwupinEntity ershouwupin,
                  HttpServletRequest request) {
        String tableName = request.getSession().getAttribute("tableName").toString();
        if (tableName.equals("yonghu")) {
            ershouwupin.setMaijiazhanghao((String) request.getSession().getAttribute("username"));
        }
        EntityWrapper<ErshouwupinEntity> ew = new EntityWrapper<ErshouwupinEntity>();


        PageUtils page = ershouwupinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, ershouwupin), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 前端列表 all
     */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, ErshouwupinEntity ershouwupin,
                  HttpServletRequest request) {
        EntityWrapper<ErshouwupinEntity> ew = new EntityWrapper<ErshouwupinEntity>();
        PageUtils page = ershouwupinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, ershouwupin), params), params));
        return R.ok().put("data", page);
//        ErshouwupinEntity entity = new ErshouwupinEntity();
//        return R.ok().put("data", entity);
    }

    /**
     * 列表
     */
    @RequestMapping("/lists")
    public R list(ErshouwupinEntity ershouwupin) {
        EntityWrapper<ErshouwupinEntity> ew = new EntityWrapper<ErshouwupinEntity>();
        ew.allEq(MPUtil.allEQMapPre(ershouwupin, "ershouwupin"));
        return R.ok().put("data", ershouwupinService.selectListView(ew));
    }

    /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ErshouwupinEntity ershouwupin) {
        EntityWrapper<ErshouwupinEntity> ew = new EntityWrapper<ErshouwupinEntity>();
        ew.allEq(MPUtil.allEQMapPre(ershouwupin, "ershouwupin"));
        ErshouwupinView ershouwupinView = ershouwupinService.selectView(ew);
        return R.ok("查询二手物品成功").put("data", ershouwupinView);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id) {
        ErshouwupinEntity ershouwupin = ershouwupinService.selectById(id);
        ershouwupin = ershouwupinService.selectView(new EntityWrapper<ErshouwupinEntity>().eq("id", id));
        return R.ok().put("data", ershouwupin);
    }

    /**
     * 前端详情
     */
    @IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id) {
        ErshouwupinEntity ershouwupin = ershouwupinService.selectById(id);
        ershouwupin = ershouwupinService.selectView(new EntityWrapper<ErshouwupinEntity>().eq("id", id));
        return R.ok().put("data", ershouwupin);
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ErshouwupinEntity ershouwupin, HttpServletRequest request) {
        //ValidatorUtils.validateEntity(ershouwupin);
        ershouwupinService.insert(ershouwupin);
        return R.ok();
    }

    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ErshouwupinEntity ershouwupin, HttpServletRequest request) {
        //ValidatorUtils.validateEntity(ershouwupin);
        ershouwupinService.insert(ershouwupin);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ErshouwupinEntity ershouwupin, HttpServletRequest request) {
        //ValidatorUtils.validateEntity(ershouwupin);
        ershouwupinService.updateById(ershouwupin);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf) {
        List<ErshouwupinEntity> list = new ArrayList<ErshouwupinEntity>();
        for (Long id : ids) {
            ErshouwupinEntity ershouwupin = ershouwupinService.selectById(id);
            ershouwupin.setSfsh(sfsh);
            ershouwupin.setShhf(shhf);
            list.add(ershouwupin);
        }
        ershouwupinService.updateBatchById(list);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids) {
        ershouwupinService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


}
