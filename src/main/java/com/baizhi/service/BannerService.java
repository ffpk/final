package com.baizhi.service;

import com.baizhi.entity.Banner;

import java.util.Map;

/**
 * Created by Administrator on 2018/10/24 0024.
 */
public interface BannerService {

    public Map byselectAll(int page, int rows);

    //删除
    public void delete(int id);
    //修改
    public void update(int id);
    //添加
    public void inset(Banner banner);

}
