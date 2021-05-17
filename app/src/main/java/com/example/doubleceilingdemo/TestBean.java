package com.example.doubleceilingdemo;

import com.chad.library.adapter.base.entity.MultiItemEntity;

public class TestBean implements MultiItemEntity {
    public static final int ITEM_HEAD_TYPE=1;
    public static final int ITEM_SEARCH_TYPE=2;
    public static final int ITEM_LIST_TYPE=3;

    private int type;
    private String title;
    private String content;

    public String getContent() {
        return content == null ? "" : content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTitle() {
        return title == null ? "" : title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int getItemType() {
        return getType();
    }
}
