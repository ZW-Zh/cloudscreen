package com.android.zzw.cloudscreen.Bean;

import java.util.ArrayList;

/**
 * Created by zzw on 2017/4/26.
 */

public class HomepageBanner {
    private ArrayList<Data> data;

    public ArrayList<Data> getData() {
        return data;
    }

    public void setData(ArrayList<Data> data) {
        this.data = data;
    }

    public class Data {
        private String imgUrl;
        private String id;
        private int type;
        private String title;

        public void setTitle(String title) {
            this.title = title;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}