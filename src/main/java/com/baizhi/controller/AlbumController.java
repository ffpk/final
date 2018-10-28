package com.baizhi.controller;

import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2018/10/25 0025.
 */
@RestController
public class AlbumController {

    @Autowired
    private AlbumService albumService;
    @RequestMapping("/albumSelectAll")
    public  List<Album> byselectAll() {
        List<Album> list = albumService.byselectAll();
        System.out.println(list);
        return list;
    }

    //添加
    //添加
    @RequestMapping("/albuminsert")
    public @ResponseBody
    boolean insert(Album album, MultipartFile file) {
        System.out.println(album);
        System.out.println(file+"----------------------------------------------------------------");

        String fileName = file.getOriginalFilename();  // 文件名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));


        // 后缀名
        String filePath = "F:\\Sources\\final\\cmfz_pl\\src\\main\\webapp\\img\\"; // 上传后的路径
        fileName = UUID.randomUUID() + suffixName; // 新文件名
        File dest = new File(filePath + fileName);

        album.setCoverImg(fileName);
        System.out.println(album.getCoverImg()+"++++++++++++++++++++++++++++++++++++++++++");
        try {
            //写入到磁盘中
            file.transferTo(dest);
            //复用service方法
            albumService.insert(album);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

}
