package com.baizhi.controller;

import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Administrator on 2018/10/24 0024.
 */
@RestController
public class BannerController {

    @Autowired
    private BannerService bannerService;

    @RequestMapping("/byselectAll")
    public @ResponseBody Map byselectAll(int page, int rows) {
        Map map = bannerService.byselectAll(page, rows);
        return map;
    }

    //删除
    @RequestMapping("/delete")
    public @ResponseBody
    boolean MyDelete(int id) {
        try {
            bannerService.delete(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /* 修改*/
    @RequestMapping("/update")
    public @ResponseBody
    boolean update(int id) {
        try {
            bannerService.update(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    //添加
    @RequestMapping("/insert")
    public boolean insert(Banner banner, MultipartFile file,HttpServletRequest request) {
        System.out.println(banner);


        String fileName = file.getOriginalFilename();  // 文件名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));

        /*String path = request.getSession().getServletContext().getRealPath("/");
        File filePath = new File(path+"/img");*/
        // 后缀名
       String filePath = "F:\\Sources\\final\\cmfz_pl\\src\\main\\webapp\\img\\"; // 上传后的路径
        fileName = UUID.randomUUID() + suffixName; // 新文件名
        File dest = new File(filePath + fileName);
        banner.setUrl(fileName);
        try {
            //写入到磁盘中
            file.transferTo(dest);
            //复用service方法
            bannerService.inset(banner);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

//添加
       /* @RequestMapping("/insert1")
        public boolean insert(Banner banner, MultipartFile file) {
        String path = request.getSession().getServletContext().getRealPath("/");
        File file1 = new File(path+"/img");
        if (!file1.exists()){
            file1.mkdir();
        }

        //   1.jpg
        String originalFilename = file.getOriginalFilename();
        String s = UUID.randomUUID().toString();
        String extension = FileNameUtils.getExtension(originalFilename);
        String newName = s +"."+ extension;
        try {
            file.transferTo(new File(file1,newName));
        } catch (IOException e) {
            e.printStackTrace();
        }*/

}
