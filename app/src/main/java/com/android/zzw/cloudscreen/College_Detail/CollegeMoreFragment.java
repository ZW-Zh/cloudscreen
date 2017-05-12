package com.android.zzw.cloudscreen.College_Detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.android.zzw.cloudscreen.Bean.College;
import com.android.zzw.cloudscreen.R;

/**
 * Created by zzw on 2017/5/7.
 */

public class CollegeMoreFragment extends Fragment {
    private WebView webView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.college_more_fragment, container, false);

        College college= (College) getArguments().getSerializable("key");
        webView= (WebView) view.findViewById(R.id.morewebview);
        webView.setBackgroundColor(0);
        WebSettings webSettings= webView.getSettings(); // webView: 类WebView的实例
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);  //就是这句
        if (college != null) {
            webView.loadDataWithBaseURL(null,college.getNewsContentHtml(),"text/html", "utf-8", null);
        }
        return view;

    }
}
