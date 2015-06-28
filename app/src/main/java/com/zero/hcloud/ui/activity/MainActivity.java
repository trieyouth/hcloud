package com.zero.hcloud.ui.activity;


import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.github.siyamed.shapeimageview.CircularImageView;
import com.zero.hcloud.R;
import com.zero.hcloud.ui.fragment.BaseFragment;
import com.zero.hcloud.ui.fragment.about.AboutFragment;
import com.zero.hcloud.ui.fragment.attention.AttentionFragment;
import com.zero.hcloud.ui.fragment.find.FindFragment;
import com.zero.hcloud.ui.fragment.home.HomeFragment;
import com.zero.hcloud.ui.fragment.message.MessageFragment;
import com.zero.hcloud.ui.fragment.person.PersonFragment;
import com.zero.hcloud.ui.fragment.schedule.ScheduleFragment;
import com.zero.hcloud.ui.fragment.setting.SettingFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends BaseActivity {


    @InjectView(R.id.activity_main_drawer_layout)
    DrawerLayout drawerLayout;
    @InjectView(R.id.activity_main_nav_view)
    NavigationView navView;
    @InjectView(R.id.activity_main_fragment_container)
    FrameLayout fragmentContainer;
    @InjectView(R.id.activity_main_toolbar)
    Toolbar toolbar;

    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        initToolbar();
        setupDrawerContent();
        initNav();
        switchFragment(R.id.drawer_home_item);
    }

    //navView的选中监听，butterknife竟然没有
    private void setupDrawerContent() {
        navView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        menuItem.setChecked(true);
                        switchFragment(menuItem.getItemId());
                        drawerLayout.closeDrawers();
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


    private void switchFragment(int resId) {
        BaseFragment fragment = null;
        switch (resId) {
            case R.id.drawer_home_item:
                fragment = new HomeFragment();
                actionBar.setTitle("首页");
                break;
            case R.id.drawer_person_item:
                fragment = new PersonFragment();
                actionBar.setTitle("个人中心");
                break;
            case R.id.drawer_attention_item:
                fragment = new AttentionFragment();
                actionBar.setTitle("关注");
                break;
            case R.id.drawer_find_item:
                fragment = new FindFragment();
                actionBar.setTitle("发现");
                break;
            case R.id.drawer_message_item:
                fragment = new MessageFragment();
                actionBar.setTitle("消息");
                break;
            case R.id.drawer_schedule_item:
                fragment = new ScheduleFragment();
                actionBar.setTitle("日程");
                break;
            case R.id.drawer_setting_item:
                fragment = new SettingFragment();
                actionBar.setTitle("设置");
                break;
            case R.id.drawer_about_item:
                fragment = new AboutFragment();
                actionBar.setTitle("关于");
                break;
            default:

                break;
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.activity_main_fragment_container,fragment).commit();
    }


    private void initToolbar() {
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("首页");
    }

    //初始化navView
    private void initNav() {
        View headerView = LayoutInflater.from(this).inflate(R.layout.nav_header, navView, false);
        NavHeaderViewHolder navHeaderViewHolder = new NavHeaderViewHolder(headerView);
        navView.addHeaderView(headerView);
        navView.inflateMenu(R.menu.drawer_menu);
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
