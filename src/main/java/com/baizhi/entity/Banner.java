package com.baizhi.entity;

import java.util.Date;

/**
 * Created by Administrator on 2018/10/24 0024.
 */
public class Banner {

    private int id;
    private String name;
    private String url="f/cmfz";
    private int status;
    private Date createDate;
    private String description;

    @Override
    public String toString() {
        return "BannerDao{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", status=" + status +
                ", createDate=" + createDate +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Banner banner = (Banner) o;

        if (id != banner.id) return false;
        if (status != banner.status) return false;
        if (name != null ? !name.equals(banner.name) : banner.name != null) return false;
        if (url != null ? !url.equals(banner.url) : banner.url != null) return false;
        if (createDate != null ? !createDate.equals(banner.createDate) : banner.createDate != null) return false;
        return description != null ? description.equals(banner.description) : banner.description == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + status;
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Banner() {
    }

    public Banner(int id, String name, String url, int status, Date createDate, String description) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.status = status;
        this.createDate = createDate;
        this.description = description;
    }
}
