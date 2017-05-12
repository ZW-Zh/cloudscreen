package com.android.zzw.cloudscreen.Bean;

/**
 * Created by zzw on 2017/4/27.
 */

public class CollegeNews {
    private State state;
    private Data data;

    public void setData(Data data) {
        this.data = data;
    }

    public Data getData() {
        return data;
    }


    public class State{
        private String info;
        private int code;

        public String getInfo() {
            return info;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public void setInfo(String info) {
            this.info = info;
        }
    }
    public class Data{
        private int newsId;
        private String newsTitle;
        private int catalogId;
        private String newsSource;
        private String imgUrl;
        private String newsContent;
        private String uptime;

        public Data(String imgUrl,String newsTitle,String newsContent){
            this.imgUrl=imgUrl;
            this.newsTitle=newsTitle;
            this.newsContent=newsContent;
        }

        public void setUptime(String uptime) {
            this.uptime = uptime;
        }

        public String getUptime() {
            return uptime;
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

        public int getNewsId() {
            return newsId;
        }

        public String getNewsSource() {
            return newsSource;
        }

        public String getNewsTitle() {
            return newsTitle;
        }
    }
}
