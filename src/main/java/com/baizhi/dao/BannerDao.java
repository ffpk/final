package com.baizhi.dao;

import com.baizhi.entity.Banner;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2018/10/24 0024.
 */
public interface BannerDao {
    public List<Banner> myselectAll(@Param("start")int start, @Param("end") int end);
    //查询总条数
    public int Count();

    //删除
    public void delete(int id);

    //修改
    public void update(int id);
    //添加
    public void insert(Banner banner);
}
