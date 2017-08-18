package com.hsyd.yycw.base;


import com.hsyd.yycw.model.PageUtil;
import com.hsyd.yycw.model.SearchModel;

import java.util.List;

/**
 * 所有接口的父类
 * Created by duan on 2017/5/18.
 */
public interface BaseMapper<Entity,Id> {

    /**
     * 添加
     * @param entity  实体
     * @return        受影响的行数
     */
    Integer insert(Entity entity);

    /**
     * 删除
     * @param id     主键
     * @return       受影响的行数
     */
    Integer delete(Id id);

    /**
     * 修改
     * @param entity 对象
     * @return       受影响的行数
     */
    Integer update(Entity entity);

    /**
     * 查询总记录数
     * @param searchModel 查询条件
     * @return             总记录数
     */
    Integer count(SearchModel searchModel);

    /**
     * 根据主键查询对象
     * @return         对象
     */
    Entity getById(Id id);

    /**
     * 查询所有对象
     * @param pageUtil   分页工具
     * @return            对象集合
     */
    List<Entity> pageQuery(PageUtil pageUtil);

}
