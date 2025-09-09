package com.cl.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.cl.entity.UsersEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;


/**
 * 管理员
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 *
 * @author
 * @email
 * @date 2025-03-21 13:53:13
 */
@TableName("users")
public class UsersView extends UsersEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    public UsersView() {
    }

    public UsersView(UsersEntity usersEntity) {
        try {
            BeanUtils.copyProperties(this, usersEntity);
        } catch (IllegalAccessException | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


}
