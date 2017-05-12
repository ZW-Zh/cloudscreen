package com.android.zzw.cloudscreen.Bean;


public class JsonsRootBean {

    private Data data;
    private String msg;
    private int status;
    public void setData(Data data) {
         this.data = data;
     }
     public Data getData() {
         return data;
     }

    public void setMsg(String msg) {
         this.msg = msg;
     }
     public String getMsg() {
         return msg;
     }

    public void setStatus(int status) {
         this.status = status;
     }
     public int getStatus() {
         return status;
     }

}