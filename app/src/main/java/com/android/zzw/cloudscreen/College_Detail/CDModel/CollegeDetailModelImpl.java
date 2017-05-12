package com.android.zzw.cloudscreen.College_Detail.CDModel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;

import com.android.zzw.cloudscreen.Adapter.CollegeDetailAdapter;
import com.android.zzw.cloudscreen.Bean.College;
import com.android.zzw.cloudscreen.Bean.CollegeNews;
import com.android.zzw.cloudscreen.College_Detail.CollegeDetailFragment;
import com.android.zzw.cloudscreen.College_Detail.CollegeMoreFragment;
import com.android.zzw.cloudscreen.R;
import com.android.zzw.cloudscreen.View.MyViewPagerTab;
import com.android.zzw.cloudscreen.utils.HttpUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by zzw on 2017/5/4.
 */

public class CollegeDetailModelImpl implements CollegeDetailModel{
    private RecyclerView recyclerViewDetail;
    private ArrayList<College> collegeList = new ArrayList<College>();
    College college;
    //当前页卡编号
    private int currIndex = 2;

    //存放Fragment
    private ArrayList<Fragment> fragmentArrayList=new ArrayList<>();

    //管理Fragment
    private FragmentManager fragmentManager;

    public static final String TAG = "MainActivity";

    private ArrayList<String> collegecontnet = new ArrayList<>();


    @Override
    public void setCollegeContnet(AppCompatActivity appCompatActivity) {
        fragmentArrayList.add(new Fragment());
        fragmentArrayList.add(new Fragment());
        fragmentArrayList.add(new CollegeDetailFragment());
        fragmentArrayList.add(new Fragment());
        fragmentArrayList.add(new Fragment());
        fragmentManager = appCompatActivity.getSupportFragmentManager();
        collegecontnet.add("校方通知");
        collegecontnet.add("最新资讯");
        collegecontnet.add("热门活动");
        collegecontnet.add("校团委");
        collegecontnet.add("学生会");
    }

    @Override
    public void InitViewPager(AppCompatActivity appCompatActivity,RecyclerView recyclerView,ViewPager viewPager) {
        MyViewPagerTab myViewPagerTab=new MyViewPagerTab(appCompatActivity,recyclerView,2,viewPager,collegecontnet,fragmentArrayList);
        myViewPagerTab.InitViewPager();
        myViewPagerTab.setOnItemClickListener(new MyViewPagerTab.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {


            }
        });
    }

    @Override
    public void setCollegeDetail(final Fragment fragment) {
        for (int i = 2; i <= 4; i++) {
            HttpUtil.sentOkHttpRequest("http://221.226.251.244:5188/wenkor_service/school/news/" + i + "/detail", new okhttp3.Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    String a = response.body().string();
                    Gson gson = new Gson();
                    java.lang.reflect.Type type = new TypeToken<CollegeNews>() {
                    }.getType();
                    CollegeNews jsonBean = gson.fromJson(a, type);
                    String content = jsonBean.getData().getNewsContent();
                    College data = new College(jsonBean.getData().getImgUrl(), jsonBean.getData().getNewsTitle(), Html.fromHtml(content).toString(),content);
                    collegeList.add(data);
                    fragment.getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            recyclerViewDetail = (RecyclerView) fragment.getActivity().findViewById(R.id.collegedeteilrv);
                            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(fragment.getContext());
                            recyclerViewDetail.setLayoutManager(linearLayoutManager);
                            CollegeDetailAdapter adapter = new CollegeDetailAdapter(fragment.getContext(), collegeList);
                            recyclerViewDetail.setAdapter(adapter);
                            adapter.setOnItemClickListener(new CollegeDetailAdapter.OnItemClickListener() {
                                @Override
                                public void onClick(int position,View v) {
                                    College data= collegeList.get(position);
                                    CollegeMoreFragment collegeMoreFragment= new CollegeMoreFragment();
                                    Bundle mBundle = new Bundle();
                                    mBundle.putSerializable("key",data);
                                    collegeMoreFragment.setArguments(mBundle);
                                    fragment.getActivity().getSupportFragmentManager().beginTransaction().addToBackStack(null).add(R.id.container,collegeMoreFragment).commit();
                                }
                            });
                        }
                    });
                }
            });
        }

            Intent intent = fragment.getActivity().getIntent();

            if (intent.getIntExtra("1", 0) == 1) {
                Bundle bundle = intent.getExtras();
                college = (College) bundle.getSerializable("2");
                CollegeMoreFragment collegeMoreFragment = new CollegeMoreFragment();
                Bundle mBundle = new Bundle();
                mBundle.putSerializable("key", college);
                collegeMoreFragment.setArguments(mBundle);
                fragment.getActivity().getSupportFragmentManager().beginTransaction().addToBackStack(null).add(R.id.container, collegeMoreFragment).commit();
                intent.removeExtra("1");
        }
    }

}
