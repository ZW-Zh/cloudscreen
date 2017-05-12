package com.android.zzw.cloudscreen.Bean;

import java.io.Serializable;

/**
 * Created by zzw on 2017/4/28.
 */

public class College implements Serializable{
    private String newsId;
    private String newsTitle;
    private int catalogId;
    private String newsSource;
    private String imgUrl;
    private String newsContent;
    private String newsContentHtml;

    public College(String imgUrl,String newsTitle,String newsContent,String newsContentHtml){
        this.imgUrl=imgUrl;
        this.newsTitle=newsTitle;
        this.newsContent=newsContent;
        this.newsContentHtml = newsContentHtml;
    }
    public String getImgUrl() {
        return imgUrl;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public String getNewsId() {
        return newsId;
    }

    public String getNewsSource() {
        return newsSource;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public String getNewsContentHtml() {
        return newsContentHtml;
    }

    public void setNewsContentHtml(String newsContentHtml) {
        this.newsContentHtml = newsContentHtml;
    }
}

