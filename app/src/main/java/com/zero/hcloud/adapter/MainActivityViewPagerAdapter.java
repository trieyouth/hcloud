package com.zero.hcloud.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MyLuffy on 2015/6/27.
 */
public class MainActivityViewPagerAdapter extends FragmentPagerAdapter {

    private List<android.support.v4.app.Fragment> fragmentList = new ArrayList<>();
    private List<String> titleList = new ArrayList<>();

    public MainActivityViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addFragment(android.support.v4.app.Fragment fragment ,String title){
        fragmentList.add(fragment);
        titleList.add(title);
    }
    @Override
    public Fragment getItem(int position) {

        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }
}
