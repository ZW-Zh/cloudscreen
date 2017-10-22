package com.android.zzw.cloudscreen.View;

import android.graphics.Color;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;

import com.android.zzw.cloudscreen.Adapter.AdapterFragment;
import com.android.zzw.cloudscreen.Adapter.ContentAdapter;
import com.android.zzw.cloudscreen.R;

import java.util.ArrayList;

/**
 * Created by zzw on 2017/5/9.
 */

public class MyViewPagerTab {
    private RecyclerView recyclerView;
    private int currIndex;
    private ViewPager mViewPager;
    private ArrayList<String> content = new ArrayList<>();
    private ArrayList<Fragment> fragmentArrayList=new ArrayList<>();
    private AppCompatActivity appCompatActivity;
    private OnItemClickListener mOnItemClickListener;
    private AdapterFragment adapterFragment;

    public MyViewPagerTab(AppCompatActivity appCompatActivity,RecyclerView recyclerView,int i,ViewPager viewPager,ArrayList<String> content,ArrayList<Fragment> fragments){
        this.recyclerView=recyclerView;
        currIndex=i;
        mViewPager=viewPager;
        this.content=content;
        this.fragmentArrayList=fragments;
        this.appCompatActivity=appCompatActivity;
    }

    public ViewPager getmViewPager() {
        return mViewPager;
    }

    public AdapterFragment getAdapterFragment() {
        return adapterFragment;
    }

    public void InitViewPager() {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(appCompatActivity);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        ContentAdapter mcontentAdapter = new ContentAdapter(content);
        recyclerView.setAdapter(mcontentAdapter);
        mcontentAdapter.setOnItemClickListener(new ContentAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                mViewPager.setCurrentItem(position);
            }
        });
        adapterFragment = new AdapterFragment(appCompatActivity.getSupportFragmentManager(), fragmentArrayList);
        mViewPager.setAdapter(adapterFragment);

        mViewPager.setCurrentItem(currIndex);


        //设置viewpager页面滑动监听事件
        mViewPager.addOnPageChangeListener(new MyOnPageChangeListener());

        new Handler().postDelayed(new Runnable(){
            public void run() {
                setText(currIndex);
                setCursor(currIndex);

            }
        },20 );



    }

    private void resetTextViewTextColor(int currIndex){

        RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
        View v=manager.getChildAt(currIndex);
        ContentAdapter.MyViewHolder contentAdapter = (ContentAdapter.MyViewHolder) recyclerView.getChildViewHolder(v);
        contentAdapter.gettextview().setTextColor(Color.parseColor("#71a4e8"));
        contentAdapter.gettextview().setBackground(null);
        contentAdapter.gettextview().setTextSize(12);
        contentAdapter.getCursor().setVisibility(View.INVISIBLE);
    }
    private void setText(int currIndex){

        RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
        View v=manager.getChildAt(currIndex);
        ContentAdapter.MyViewHolder contentAdapter = (ContentAdapter.MyViewHolder) recyclerView.getChildViewHolder(v);
        contentAdapter.gettextview().setTextColor(Color.parseColor("#ffffff"));
        contentAdapter.gettextview().setTextSize(15);
        contentAdapter.gettextview().setBackgroundResource(R.drawable.contentbg);
    }
    private void setCursor(int currIndex){

        RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
        View v=manager.getChildAt(currIndex);
        ContentAdapter.MyViewHolder contentAdapter = (ContentAdapter.MyViewHolder) recyclerView.getChildViewHolder(v);
        contentAdapter.getCursor().setVisibility(View.VISIBLE);
    }
    public class MyOnPageChangeListener implements ViewPager.OnPageChangeListener{

        @Override
        public void onPageSelected(int p) {
            resetTextViewTextColor(currIndex);
            setText(p);
            setCursor(p);
            currIndex = p;
            mOnItemClickListener.onItemClick(p);
        }

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }
    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}
