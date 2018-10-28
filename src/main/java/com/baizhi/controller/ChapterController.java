package com.baizhi.controller;

import com.baizhi.entity.Chapter;
import com.baizhi.service.ChapterService;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.MultimediaInfo;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.UUID;

/**
 * Created by Administrator on 2018/10/26 0026.
 */

@RestController
public class ChapterController {

    @Autowired
    private ChapterService chapterService;


    @RequestMapping("/chapTerinsert")
    public @ResponseBody boolean insert(Chapter chapter, MultipartFile file ,int Albumid ){
        //System.out.println("jinlaee@------------------------------");
       // System.out.println(chapter);
        //System.out.println(file+"----------------------------------------------------------------");
        //把id和UUID拼接起来
        boolean data=false;
        if(file!=null){
        chapter.setAlbum_id(Albumid);
        String s = UUID.randomUUID().toString();
       // System.out.println(s);
        chapter.setId(s);

        String fileName = file.getOriginalFilename();  // 文件名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        // 后缀名
        String filePath = "F:\\Sources\\final\\cmfz_pl\\src\\main\\webapp\\img\\"; // 上传后的路径
        fileName = UUID.randomUUID() + suffixName; // 新文件名
        File dest = new File(filePath + fileName);

        chapter.setUrl(fileName);
        System.out.println(chapter.getUrl()+"++++++++++++++++++++++++++++++++++++++++++");
            //写入到磁盘中
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //视频大小
        long size1 = file.getSize()/1024/1024;//默认是字节
        System.out.println(size1);
        String size2=size1+"MB";
        chapter.setSize(size2);
        //视频时长
        //获取视频的存储位置
        File source = new File(filePath + fileName);
        System.out.println(source);
        Encoder encoder = new Encoder();
        MultimediaInfo m = null;
        try {
            m = encoder.getInfo(source);
        } catch (EncoderException e) {
            e.printStackTrace();
        }
        long ls = m.getDuration();
        System.out.println(ls+"...........................................................................................");
        //获得分钟
        long second = ls/1000/60;
        long second1 = ls/1000%60;

        System.out.println("此视频时长为:" + second + "秒！");
        String s1=second+":"+second1;
        chapter.setDuration(s1);
        //复用service方法
        chapterService.insertInto(chapter);
        data=true;
        }
        return data;
    }



    @RequestMapping("/down")
    public void down(String name, String url, HttpServletRequest request, HttpServletResponse response) {

        //获取文件的路径
        String realPath = request.getSession().getServletContext().getRealPath("/img");
        //定位到要下载的文件
        String filePath = realPath + "/" + url;

        File audioFile=new File(filePath);

        String extension = FilenameUtils.getExtension(url);
        String newName = name + "." + extension;

        try {
            response.setHeader("Content-Disposition","attachment;fileName="+ URLEncoder.encode(newName,"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //音频的下载格式
        response.setContentType("audio/mpeg");
        try {
            //响应文件  下载
            ServletOutputStream outputStream = response.getOutputStream();
            outputStream.write(FileUtils.readFileToByteArray(audioFile));
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
