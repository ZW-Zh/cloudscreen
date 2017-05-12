package com.android.zzw.cloudscreen.Bean;

import android.widget.ImageView;

import java.io.Serializable;

/**
 * Created by zzw on 2017/5/10.
 */

public class WenkeBean implements Serializable{
    private String activity;
    private ImageView img;
    private int imgid;

    public WenkeBean(String activity,int imgid){
        this.activity=activity;
        this.imgid=imgid;
    }
    public ImageView getImg() {
        return img;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public void setImg(ImageView img) {
        this.img = img;
    }

    public void setImgid(int imgid) {
        this.imgid = imgid;
    }

    public int getImgid() {
        return imgid;
    }
}
