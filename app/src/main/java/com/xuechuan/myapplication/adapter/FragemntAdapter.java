package com.xuechuan.myapplication.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * @version V 1.0 xxxxxxxx
 * @Title: demo
 * @Package com.xuechuan.myapplication.adapter
 * @Description: todo
 * @author: L-BackPacker
 * @date: 2018/9/10 10:59
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2018
 */
public class FragemntAdapter extends FragmentPagerAdapter {

    private List<String> mTitle;
    private List<Fragment> mFragments;

    public FragemntAdapter(FragmentManager fm, List<String> mTitle, List<Fragment> mFragments) {
        super(fm);
        this.mTitle = mTitle;
        this.mFragments = mFragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitle.get(position);
    }
}
