package com.baizhi.entity;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/10/25 0025.
 */
//专辑表
public class Album {
    private int id;
    private String name; //专辑名字
    private String coverImg; //封面图片
    private int count; //音频集数
    private int score;//专辑的评分
    private String author;//作者
    private String broadCat;//视频播音人
    private String brief;// 简介
    private Date publicDate;//公开时间
    private List<Chapter> children;
    public Album() {
    }

    public Album(int id, String name, String coverImg, int count, int score, String author, String broadCat, String brief, Date publicDate) {
        this.id = id;
        this.name = name;
        this.coverImg = coverImg;
        this.count = count;
        this.score = score;
        this.author = author;
        this.broadCat = broadCat;
        this.brief = brief;
        this.publicDate = publicDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBroadCat() {
        return broadCat;
    }

    public void setBroadCat(String broadCat) {
        this.broadCat = broadCat;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public Date getPublicDate() {
        return publicDate;
    }

    public void setPublicDate(Date publicDate) {
        this.publicDate = publicDate;
    }

    public List<Chapter> getChildren() {
        return children;
    }

    public void setChildren(List<Chapter> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coverImg='" + coverImg + '\'' +
                ", count=" + count +
                ", score=" + score +
                ", author='" + author + '\'' +
                ", broadCat='" + broadCat + '\'' +
                ", brief='" + brief + '\'' +
                ", publicDate=" + publicDate +
                ", children=" + children +
                '}';
    }
}
