package com.android.zzw.cloudscreen.Details;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.android.zzw.cloudscreen.R;

/**
 * Created by zzw on 2017/5/11.
 */

public class DetailFragment extends Fragment {
    private WebView webView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.detail_fragment, container, false);
        webView = (WebView) view.findViewById(R.id.detailwebview);
        WebSettings settings = webView.getSettings();
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        webView.setBackgroundColor(0);

        /*((DetailActivity)getActivity()).getDetailmodellmp().getMyViewPagerTab().setOnItemClickListener(new MyViewPagerTab.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                System.out.println(position);
                switch (position) {
                    case 0:
                        webView.loadUrl(Api.QIANDAO);
                        break;
                    case 1:
                        webView.loadUrl(Api.FULI);
                        break;
                    case 2:
                        webView.loadUrl("about:blank");
                        break;
                    case 3:
                        webView.loadUrl("about:blank");
                        break;
                }
            }
        });*/
        return view;
    }

    public WebView getWebView() {
        return webView;
    }
}
