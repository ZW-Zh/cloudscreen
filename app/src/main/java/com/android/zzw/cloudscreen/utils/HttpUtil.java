package com.android.zzw.cloudscreen.utils;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by zzw on 2017/4/26.
 */

public class HttpUtil {
    public static void sentOkHttpRequest(String address,okhttp3.Callback callback){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(address).build();
        client.newCall(request).enqueue(callback);
    }
}
