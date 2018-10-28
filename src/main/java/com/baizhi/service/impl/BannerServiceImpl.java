package com.baizhi.service.impl;

import com.baizhi.dao.BannerDao;
import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/10/24 0024.
 */
@Service
@Transactional
public class BannerServiceImpl implements BannerService {

    @Autowired
    private BannerDao bannerDao;
    //分页
    @Override
    public Map byselectAll(int page, int rows) {
        Map map=new HashMap();

        int start=(page-1)*rows;

        int end=page*rows;
        List<Banner> list = bannerDao.myselectAll(start, end);
        //获得总条数
        int count = bannerDao.Count();
        //把值存入map中 key的名字框架已经定义好的
        map.put("rows", list);

        map.put("total", count);
        return map;
    }

    @Override
    public void delete(int id) {
        bannerDao.delete(id);
    }

    @Override
    public void update(int id) {
        bannerDao.update(id);
    }

    @Override
    public void inset(Banner banner) {
        bannerDao.insert(banner);
    }


}
