package com.android.zzw.cloudscreen.utils;

import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by zzw on 2017/5/8.
 */

public class TransparentStatusBar {
    public static void setTransparentStatusBar(AppCompatActivity appCompatActivity) {
        //透明状态栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {//4.4 全透明状态栏
            appCompatActivity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//5.0 全透明实现
            Window window = appCompatActivity.getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);//calculateStatusColor(Color.WHITE, (int) alphaValue)
        }
    }
}
