package com.baizhi.entity;

/**
 * Created by Administrator on 2018/10/25 0025.
 */

//章节表
public class Chapter {
    private String id;
    private String name;  //标题
    private String url;  //音频的路径
    private String size; //音频长度
    private String duration;//音频播放时长
    private int album_id;

    public Chapter() {
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", size='" + size + '\'' +
                ", duration='" + duration + '\'' +
                ", album_id=" + album_id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Chapter chapter = (Chapter) o;

        if (album_id != chapter.album_id) return false;
        if (id != null ? !id.equals(chapter.id) : chapter.id != null) return false;
        if (name != null ? !name.equals(chapter.name) : chapter.name != null) return false;
        if (url != null ? !url.equals(chapter.url) : chapter.url != null) return false;
        if (size != null ? !size.equals(chapter.size) : chapter.size != null) return false;
        return duration != null ? duration.equals(chapter.duration) : chapter.duration == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (size != null ? size.hashCode() : 0);
        result = 31 * result + (duration != null ? duration.hashCode() : 0);
        result = 31 * result + album_id;
        return result;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getAlbum_id() {
        return album_id;
    }

    public void setAlbum_id(int album_id) {
        this.album_id = album_id;
    }

    public Chapter(String id, String name, String url, String size, String duration, int album_id) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.size = size;
        this.duration = duration;
        this.album_id = album_id;
    }
}
