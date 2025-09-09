package com.cl.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.cl.annotation.IgnoreAuth;
import com.cl.entity.DiscussershouwupinEntity;
import com.cl.entity.view.DiscussershouwupinView;
import com.cl.service.DiscussershouwupinService;
import com.cl.utils.MPUtil;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 二手物品评论表
 * 后端接口
 *
 * @author
 * @email
 * @date 2025-03-21 13:53:14
 */
@RestController
@RequestMapping("/discussershouwupin")
public class DiscussershouwupinController {
    @Autowired
    private DiscussershouwupinService discussershouwupinService;


    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, DiscussershouwupinEntity discussershouwupin,
                  HttpServletRequest request) {
        EntityWrapper<DiscussershouwupinEntity> ew = new EntityWrapper<DiscussershouwupinEntity>();


        PageUtils page = discussershouwupinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussershouwupin), params), params));
        return R.ok().put("data", page);
    }


    /**
     * 前端列表
     */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, DiscussershouwupinEntity discussershouwupin,
                  HttpServletRequest request) {
        EntityWrapper<DiscussershouwupinEntity> ew = new EntityWrapper<DiscussershouwupinEntity>();

        PageUtils page = discussershouwupinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussershouwupin), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/lists")
    public R list(DiscussershouwupinEntity discussershouwupin) {
        EntityWrapper<DiscussershouwupinEntity> ew = new EntityWrapper<DiscussershouwupinEntity>();
        ew.allEq(MPUtil.allEQMapPre(discussershouwupin, "discussershouwupin"));
        return R.ok().put("data", discussershouwupinService.selectListView(ew));
    }

    /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussershouwupinEntity discussershouwupin) {
        EntityWrapper<DiscussershouwupinEntity> ew = new EntityWrapper<DiscussershouwupinEntity>();
        ew.allEq(MPUtil.allEQMapPre(discussershouwupin, "discussershouwupin"));
        DiscussershouwupinView discussershouwupinView = discussershouwupinService.selectView(ew);
        return R.ok("查询二手物品评论表成功").put("data", discussershouwupinView);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id) {
        DiscussershouwupinEntity discussershouwupin = discussershouwupinService.selectById(id);
        discussershouwupin = discussershouwupinService.selectView(new EntityWrapper<DiscussershouwupinEntity>().eq("id", id));
        return R.ok().put("data", discussershouwupin);
    }

    /**
     * 前端详情
     */
    @IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id) {
        DiscussershouwupinEntity discussershouwupin = discussershouwupinService.selectById(id);
        discussershouwupin = discussershouwupinService.selectView(new EntityWrapper<DiscussershouwupinEntity>().eq("id", id));
        return R.ok().put("data", discussershouwupin);
    }


    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussershouwupinEntity discussershouwupin, HttpServletRequest request) {
        //ValidatorUtils.validateEntity(discussershouwupin);
        discussershouwupinService.insert(discussershouwupin);
        return R.ok();
    }

    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussershouwupinEntity discussershouwupin, HttpServletRequest request) {
        //ValidatorUtils.validateEntity(discussershouwupin);
        discussershouwupinService.insert(discussershouwupin);
        return R.ok();
    }

    /**
     * 获取用户密保
     */
    @RequestMapping("/security")
    @IgnoreAuth
    public R security(@RequestParam String username) {
        DiscussershouwupinEntity discussershouwupin = discussershouwupinService.selectOne(new EntityWrapper<DiscussershouwupinEntity>().eq("", username));
        return R.ok().put("data", discussershouwupin);
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @IgnoreAuth
    public R update(@RequestBody DiscussershouwupinEntity discussershouwupin, HttpServletRequest request) {
        //ValidatorUtils.validateEntity(discussershouwupin);
        discussershouwupinService.updateById(discussershouwupin);//全部更新
        return R.ok();
    }


    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids) {
        discussershouwupinService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 前端智能排序
     */
    @IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params, DiscussershouwupinEntity discussershouwupin, HttpServletRequest request, String pre) {
        EntityWrapper<DiscussershouwupinEntity> ew = new EntityWrapper<DiscussershouwupinEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
        Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Object> entry = it.next();
            String key = entry.getKey();
            String newKey = entry.getKey();
            if (pre.endsWith(".")) {
                newMap.put(pre + newKey, entry.getValue());
            } else if (StringUtils.isEmpty(pre)) {
                newMap.put(newKey, entry.getValue());
            } else {
                newMap.put(pre + "." + newKey, entry.getValue());
            }
        }
        params.put("sort", "clicktime");
        params.put("order", "desc");
        PageUtils page = discussershouwupinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussershouwupin), params), params));
        return R.ok().put("data", page);
    }


}
