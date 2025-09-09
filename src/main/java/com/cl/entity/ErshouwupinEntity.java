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
 * 二手物品
 * 数据库通用操作实体类（普通增删改查）
 *
 * @author
 * @email
 * @date 2025-03-21 13:53:13
 */
@TableName("ershouwupin")
public class ErshouwupinEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键id
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 商品名称
     */

    private String shangpinmingcheng;
    /**
     * 外观
     */

    private String waiguan;
    /**
     * 商品分类
     */

    private String shangpinfenlei;
    /**
     * 品牌
     */

    private String pinpai;
    /**
     * 新旧程度
     */

    private String xinjiuchengdu;
    /**
     * 原产厂家
     */

    private String yuanchanchangjia;
    /**
     * 用途
     */

    private String yongtu;
    /**
     * 具体材质
     */

    private String juticaizhi;
    /**
     * 产品描述
     */

    private String chanpinmiaoshu;
    /**
     * 价格
     */

    private Double price;
    /**
     * 单限
     */

    private Integer onelimittimes;
    /**
     * 库存
     */

    private Integer alllimittimes;
    /**
     * 卖家账号
     */

    private String maijiazhanghao;
    /**
     * 卖家姓名
     */

    private String maijiaxingming;
    /**
     * 是否审核
     */

    private String sfsh;
    /**
     * 回复内容
     */

    private String shhf;
    /**
     * 评论数
     */

    private Integer discussNumber;
    /**
     * 收藏数
     */

    private Integer storeupNumber;
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat
    private Date addtime;

    public ErshouwupinEntity() {

    }


    public ErshouwupinEntity(T t) {
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
     * 获取：商品名称
     */
    public String getShangpinmingcheng() {
        return shangpinmingcheng;
    }

    /**
     * 设置：商品名称
     */
    public void setShangpinmingcheng(String shangpinmingcheng) {
        this.shangpinmingcheng = shangpinmingcheng;
    }

    /**
     * 获取：外观
     */
    public String getWaiguan() {
        return waiguan;
    }

    /**
     * 设置：外观
     */
    public void setWaiguan(String waiguan) {
        this.waiguan = waiguan;
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

    /**
     * 获取：品牌
     */
    public String getPinpai() {
        return pinpai;
    }

    /**
     * 设置：品牌
     */
    public void setPinpai(String pinpai) {
        this.pinpai = pinpai;
    }

    /**
     * 获取：新旧程度
     */
    public String getXinjiuchengdu() {
        return xinjiuchengdu;
    }

    /**
     * 设置：新旧程度
     */
    public void setXinjiuchengdu(String xinjiuchengdu) {
        this.xinjiuchengdu = xinjiuchengdu;
    }

    /**
     * 获取：原产厂家
     */
    public String getYuanchanchangjia() {
        return yuanchanchangjia;
    }

    /**
     * 设置：原产厂家
     */
    public void setYuanchanchangjia(String yuanchanchangjia) {
        this.yuanchanchangjia = yuanchanchangjia;
    }

    /**
     * 获取：用途
     */
    public String getYongtu() {
        return yongtu;
    }

    /**
     * 设置：用途
     */
    public void setYongtu(String yongtu) {
        this.yongtu = yongtu;
    }

    /**
     * 获取：具体材质
     */
    public String getJuticaizhi() {
        return juticaizhi;
    }

    /**
     * 设置：具体材质
     */
    public void setJuticaizhi(String juticaizhi) {
        this.juticaizhi = juticaizhi;
    }

    /**
     * 获取：产品描述
     */
    public String getChanpinmiaoshu() {
        return chanpinmiaoshu;
    }

    /**
     * 设置：产品描述
     */
    public void setChanpinmiaoshu(String chanpinmiaoshu) {
        this.chanpinmiaoshu = chanpinmiaoshu;
    }

    /**
     * 获取：价格
     */
    public Double getPrice() {
        return price;
    }

    /**
     * 设置：价格
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * 获取：单限
     */
    public Integer getOnelimittimes() {
        return onelimittimes;
    }

    /**
     * 设置：单限
     */
    public void setOnelimittimes(Integer onelimittimes) {
        this.onelimittimes = onelimittimes;
    }

    /**
     * 获取：库存
     */
    public Integer getAlllimittimes() {
        return alllimittimes;
    }

    /**
     * 设置：库存
     */
    public void setAlllimittimes(Integer alllimittimes) {
        this.alllimittimes = alllimittimes;
    }

    /**
     * 获取：卖家账号
     */
    public String getMaijiazhanghao() {
        return maijiazhanghao;
    }

    /**
     * 设置：卖家账号
     */
    public void setMaijiazhanghao(String maijiazhanghao) {
        this.maijiazhanghao = maijiazhanghao;
    }

    /**
     * 获取：卖家姓名
     */
    public String getMaijiaxingming() {
        return maijiaxingming;
    }

    /**
     * 设置：卖家姓名
     */
    public void setMaijiaxingming(String maijiaxingming) {
        this.maijiaxingming = maijiaxingming;
    }

    /**
     * 获取：是否审核
     */
    public String getSfsh() {
        return sfsh;
    }

    /**
     * 设置：是否审核
     */
    public void setSfsh(String sfsh) {
        this.sfsh = sfsh;
    }

    /**
     * 获取：回复内容
     */
    public String getShhf() {
        return shhf;
    }

    /**
     * 设置：回复内容
     */
    public void setShhf(String shhf) {
        this.shhf = shhf;
    }

    /**
     * 获取：评论数
     */
    public Integer getDiscussNumber() {
        return discussNumber;
    }

    /**
     * 设置：评论数
     */
    public void setDiscussNumber(Integer discussNumber) {
        this.discussNumber = discussNumber;
    }

    /**
     * 获取：收藏数
     */
    public Integer getStoreupNumber() {
        return storeupNumber;
    }

    /**
     * 设置：收藏数
     */
    public void setStoreupNumber(Integer storeupNumber) {
        this.storeupNumber = storeupNumber;
    }

}
