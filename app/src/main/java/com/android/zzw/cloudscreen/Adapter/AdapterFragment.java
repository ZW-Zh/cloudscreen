package com.android.zzw.cloudscreen.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import com.android.zzw.cloudscreen.Details.DetailFragment;

import java.util.ArrayList;

/**
 * Created by zzw on 2017/4/19.
 */

public class AdapterFragment extends FragmentStatePagerAdapter{
    ArrayList<Fragment> mFragments;
    public Fragment currentFragment;

    public AdapterFragment(FragmentManager fm,ArrayList<Fragment> mFragments) {
        super(fm);
        this.mFragments=mFragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        currentFragment=(Fragment)object;
        super.setPrimaryItem(container, position, object);
    }
}
