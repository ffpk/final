package com.baizhi.test;

import com.baizhi.CmfzApp;
import com.baizhi.dao.AlbumDao;
import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
import org.junit.Test;
import org.junit.internal.Classes;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/10/25 0025.
 */
//开启SpringBoot自动配置
@SpringBootTest(classes= CmfzApp.class)
//开启Spring工厂创建对象
@RunWith(SpringRunner.class)
public class AlbumTest {
    @Autowired
    private AlbumService albumService;
    @Autowired
    private AlbumDao albumDao;
    @Test
    public void TestA(){
        List<Album> albums = albumService.byselectAll();
        System.out.println(albums);
    }



}
