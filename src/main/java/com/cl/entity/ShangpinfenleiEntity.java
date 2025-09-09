package com.cl.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;


/**
 * 商品分类
 * 数据库通用操作实体类（普通增删改查）
 *
 * @author
 * @email
 * @date 2025-03-21 13:53:13
 */
@TableName("shangpinfenlei")
public class ShangpinfenleiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键id
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 商品分类
     */

    private String shangpinfenlei;
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat
    private Date addtime;
    public ShangpinfenleiEntity() {

    }


    public ShangpinfenleiEntity(T t) {
        try {
            BeanUtils.copyProperties(this, t);
        } catch (IllegalAccessException | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取：商品分类
     */
    public String getShangpinfenlei() {
        return shangpinfenlei;
    }

    /**
     * 设置：商品分类
     */
    public void setShangpinfenlei(String shangpinfenlei) {
        this.shangpinfenlei = shangpinfenlei;
    }

}
