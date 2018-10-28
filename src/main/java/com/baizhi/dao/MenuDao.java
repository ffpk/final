package com.baizhi.dao;

import com.baizhi.entity.Menu;

import java.util.List;

/**
 * Created by Administrator on 2018/10/23 0023.
 */
public interface MenuDao {
    //查询一级类别id查询一级类别名称
    public List<Menu> getCategoryTree();


}
