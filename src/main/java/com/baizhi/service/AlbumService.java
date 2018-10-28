package com.baizhi.service;


import com.baizhi.entity.Album;

import java.util.List;

/**
 * Created by Administrator on 2018/10/25 0025.
 */
public interface AlbumService {
        //表连接加分页查询
    public List<Album> byselectAll();

    //添加专辑
    public void insert(Album album);
}
