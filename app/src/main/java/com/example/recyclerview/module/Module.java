package com.example.recyclerview.module;

import java.io.Serializable;

public class Module implements Serializable {
    private Integer icon;
    private String title;
    private String description;
    private String category;

    /*
    * module constructor
    * @param icon
    * @param title
    * @param description
    * @param category
    */
    public Module(Integer icon, String title, String description, String category) {
        this.icon = icon;
        this.title = title;
        this.description = description;
        this.category = category;
    }

    public Module() {
    }

    public Integer getIcon() {
        return icon;
    }

    public void setIcon(Integer icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
