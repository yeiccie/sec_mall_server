package com.cl.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.cl.annotation.IgnoreAuth;
import com.cl.entity.MenuEntity;
import com.cl.entity.view.MenuView;
import com.cl.service.MenuService;
import com.cl.utils.MPUtil;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Map;

/**
 * 菜单
 * 后端接口
 *
 * @author
 * @email
 * @date 2025-03-21 13:53:14
 */
@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;


    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, MenuEntity menu,
                  HttpServletRequest request) {
        EntityWrapper<MenuEntity> ew = new EntityWrapper<MenuEntity>();


        PageUtils page = menuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, menu), params), params));
        return R.ok().put("data", page);
    }


    /**
     * 前端列表
     */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, MenuEntity menu,
                  HttpServletRequest request) {
        EntityWrapper<MenuEntity> ew = new EntityWrapper<MenuEntity>();

        PageUtils page = menuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, menu), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/lists")
    public R list(MenuEntity menu) {
        EntityWrapper<MenuEntity> ew = new EntityWrapper<MenuEntity>();
        ew.allEq(MPUtil.allEQMapPre(menu, "menu"));
        return R.ok().put("data", menuService.selectListView(ew));
    }

    /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(MenuEntity menu) {
        EntityWrapper<MenuEntity> ew = new EntityWrapper<MenuEntity>();
        ew.allEq(MPUtil.allEQMapPre(menu, "menu"));
        MenuView menuView = menuService.selectView(ew);
        return R.ok("查询菜单成功").put("data", menuView);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id) {
        MenuEntity menu = menuService.selectById(id);
        menu = menuService.selectView(new EntityWrapper<MenuEntity>().eq("id", id));
        return R.ok().put("data", menu);
    }

    /**
     * 前端详情
     */
    @IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id) {
        MenuEntity menu = menuService.selectById(id);
        menu = menuService.selectView(new EntityWrapper<MenuEntity>().eq("id", id));
        return R.ok().put("data", menu);
    }


    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody MenuEntity menu, HttpServletRequest request) {
        //ValidatorUtils.validateEntity(menu);
        menuService.insert(menu);
        return R.ok();
    }

    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody MenuEntity menu, HttpServletRequest request) {
        //ValidatorUtils.validateEntity(menu);
        menuService.insert(menu);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody MenuEntity menu, HttpServletRequest request) {
        //ValidatorUtils.validateEntity(menu);
        menuService.updateById(menu);//全部更新
        return R.ok();
    }


    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids) {
        menuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


}
