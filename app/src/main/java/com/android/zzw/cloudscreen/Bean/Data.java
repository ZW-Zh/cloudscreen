package com.android.zzw.cloudscreen.Bean;
import java.util.List;

public class Data {

    private List<Banner> banner;
    private List<Colorlump> colorlump;
    private List<Hotpdt> hotpdt;
    private String morepdt;
    public void setBanner(List<Banner> banner) {
         this.banner = banner;
     }
     public List<Banner> getBanner() {
         return banner;
     }

    public void setColorlump(List<Colorlump> colorlump) {
         this.colorlump = colorlump;
     }
     public List<Colorlump> getColorlump() {
         return colorlump;
     }

    public void setHotpdt(List<Hotpdt> hotpdt) {
         this.hotpdt = hotpdt;
     }
     public List<Hotpdt> getHotpdt() {
         return hotpdt;
     }

    public void setMorepdt(String morepdt) {
         this.morepdt = morepdt;
     }
     public String getMorepdt() {
         return morepdt;
     }

}