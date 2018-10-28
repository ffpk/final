package com.baizhi.entity;

import java.util.List;

/**
 * Created by Administrator on 2018/10/23 0023.
 */
public class Menu {
    private int id;
    private String title;
    private String iconcle;
    private String url;
    private List<Menu> menuslist;
    public Menu() {
    }

    @Override
    public String
    toString() {
        return "Menu{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", iconcle='" + iconcle + '\'' +
                ", url='" + url + '\'' +
                ", menuslist=" + menuslist +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Menu menu = (Menu) o;

        if (id != menu.id) return false;
        if (title != null ? !title.equals(menu.title) : menu.title != null) return false;
        if (iconcle != null ? !iconcle.equals(menu.iconcle) : menu.iconcle != null) return false;
        if (url != null ? !url.equals(menu.url) : menu.url != null) return false;
        return menuslist != null ? menuslist.equals(menu.menuslist) : menu.menuslist == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (iconcle != null ? iconcle.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (menuslist != null ? menuslist.hashCode() : 0);
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIconcle() {
        return iconcle;
    }

    public void setIconcle(String iconcle) {
        this.iconcle = iconcle;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Menu> getMenuslist() {
        return menuslist;
    }

    public void setMenuslist(List<Menu> menuslist) {
        this.menuslist = menuslist;
    }

    public Menu(int id, String title, String iconcle, String url, List<Menu> menuslist) {
        this.id = id;
        this.title = title;
        this.iconcle = iconcle;
        this.url = url;
        this.menuslist = menuslist;
    }



}
