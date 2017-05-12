package com.android.zzw.cloudscreen.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;

import com.android.zzw.cloudscreen.R;
import com.bumptech.glide.Glide;

/**
 * Created by zzw on 2017/4/26.
 */

public class ViewFactory {
    public static ImageView getImageView( Context context,String url) {
        ImageView imageView = (ImageView) LayoutInflater.from(context).inflate(
                R.layout.view_banner, null);
                Glide.with(context).load(url).centerCrop().into(imageView);
        return imageView;
    }
}
