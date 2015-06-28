package com.zero.hcloud.ui.activity;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.github.siyamed.shapeimageview.CircularImageView;
import com.zero.hcloud.R;
import com.zero.hcloud.adapter.MainActivityViewPagerAdapter;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @InjectView(R.id.activity_main_toolbar)
    Toolbar toolbar;
    @InjectView(R.id.activity_main_tabs)
    TabLayout tabs;
    @InjectView(R.id.activity_main_viewpager)
    ViewPager viewpager;
    @InjectView(R.id.activity_main_fab)
    FloatingActionButton fab;
    @InjectView(R.id.activity_main_nav_view)
    NavigationView navView;
    @InjectView(R.id.activity_main_drawer_layout)
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        initToolbar();
        initViewPager();
        initTabs();
        setupDrawerContent();
        initNav();
    }

    //navView的选中监听，butterknife竟然没有
    private void setupDrawerContent() {
        navView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        menuItem.setChecked(true);
                        drawerLayout.closeDrawers();
                        //TO-DO fragment change
                        return true;
                    }
                });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    //初始化toolbar
    private void initToolbar() {
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    //初始化viewpager
    private void initViewPager() {
        viewpager.setAdapter(new MainActivityViewPagerAdapter(getSupportFragmentManager()));
    }

    //初始化tabs
    private void initTabs() {
        tabs.setupWithViewPager(viewpager);
    }

    //初始化navView
    private void initNav() {
        View headerView = LayoutInflater.from(this).inflate(R.layout.nav_header, navView, false);
        navView.addHeaderView(headerView);
        navView.inflateMenu(R.menu.drawer_menu);
    }

    //fab的点击事件
    @OnClick(R.id.activity_main_fab)
    public void fabClick() {

    }

    /**
     * This class contains all butterknife-injected Views & Layouts from layout file 'nav_header.xml'
     * for easy to all layout elements.
     *
     * @author ButterKnifeZelezny, plugin for Android Studio by Avast Developers (http://github.com/avast)
     */
    class NavHeaderViewHolder {
        @InjectView(R.id.drawer_head_img)
        CircularImageView drawerHeadImg;
        @InjectView(R.id.drawer_username_text)
        TextView drawerUsernameText;

        NavHeaderViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }

}
