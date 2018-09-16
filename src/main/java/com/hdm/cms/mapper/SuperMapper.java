package com.hdm.cms.mapper;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by huangdaming on 2018-09-15.
 */
public interface SuperMapper<T,ID extends Serializable>{

    /**
     * 新增
     * @param t 实体
     * @return 新增的的数量
     */
    int insert(T t);
    /**
     * 修改
     * @param t 修改的实体
     * @return 修改成功的数量
     */
    int update(T t);
    /**
     * 根据ID删除实体
     * @param id
     * @return
     */
    int delete(ID id);
    /**
     * 通过ID查询实体
     * @param id
     * @return
     */
    T get(ID id);
    /**
     * 通过实体的字段条件查询实体
     * @param params
     * @return
     */
    List<T> query(Map params);
}
