package com.baizhi.dao;

import com.baizhi.entity.Album;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2018/10/25 0025.
 */
//音频
public interface AlbumDao {
    //查询全部的章节
    public List<Album> getCategoryTree();

    //添加专辑
    public void insert(Album album);



}
