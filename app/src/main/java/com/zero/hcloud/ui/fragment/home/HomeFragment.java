package com.zero.hcloud.ui.fragment.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.zero.hcloud.R;
import com.zero.hcloud.adapter.HomeFragmentViewPagerAdapter;
import com.zero.hcloud.ui.fragment.BaseFragment;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by MyLuffy on 2015/6/28.
 */
public class HomeFragment extends BaseFragment {


    @InjectView(R.id.fragment_home_tabs)
    TabLayout tabs;
    @InjectView(R.id.fragment_home_viewpager)
    ViewPager viewpager;
//    @InjectView(R.id.fragment_home_fab)
//    FloatingActionButton fab;
    HomeFragmentViewPagerAdapter adapter ;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = getCententView(inflater,R.layout.fragment_home);
        ButterKnife.inject(this, view);
        addFragment();
        initViewPager();
        initTabs();
        return view;
    }

    //初始化viewpager
    private void initViewPager() {

        viewpager.setAdapter(adapter);
    }

    private void addFragment(){
        adapter=new HomeFragmentViewPagerAdapter(getActivity().getSupportFragmentManager());
        adapter.addFragment(new GeneralFragment(),"推荐");
        adapter.addFragment(new GeneralFragment(),"取快递");
        adapter.addFragment(new GeneralFragment(),"取外卖");
    }

    //初始化tabs
    private void initTabs() {
        tabs.setupWithViewPager(viewpager);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
