package com.zero.hcloud.model.impl;

import android.support.v4.app.Fragment;

import com.zero.hcloud.R;
import com.zero.hcloud.model.IAMainModel;
import com.zero.hcloud.ui.fragment.BaseFragment;
import com.zero.hcloud.ui.fragment.about.AboutFragment;
import com.zero.hcloud.ui.fragment.attention.AttentionFragment;
import com.zero.hcloud.ui.fragment.find.FindFragment;
import com.zero.hcloud.ui.fragment.home.HomeFragment;
import com.zero.hcloud.ui.fragment.message.MessageFragment;
import com.zero.hcloud.ui.fragment.person.PersonFragment;
import com.zero.hcloud.ui.fragment.schedule.ScheduleFragment;
import com.zero.hcloud.ui.fragment.setting.SettingFragment;

/**
 * Created by MyLuffy on 2015/6/29.
 */
public class AMainModelImpl implements IAMainModel{

    @Override
    public String getToolbarTitle(int resId)  {
        String str = "";
        switch (resId) {
            case R.id.drawer_home_item:
                str = "首页";
                break;
            case R.id.drawer_person_item:
                str = "个人中心";
                break;
            case R.id.drawer_attention_item:
                str = "关注";
                break;
            case R.id.drawer_find_item:
                str = ("发现");
                break;
            case R.id.drawer_message_item:
                str = ("消息");
                break;
            case R.id.drawer_schedule_item:
                str = ("日程");
                break;
            case R.id.drawer_setting_item:
                str = ("设置");
                break;
            case R.id.drawer_about_item:
                str = ("关于");
                break;
            default:
                if(str == null) {
                    throw  new NullPointerException("actionbar title is null");
                }
                break;
        }
        return str;
    }

    @Override
    public Fragment getFragment(int resId) {
        BaseFragment fragment = null;
        switch (resId) {
            case R.id.drawer_home_item:
                fragment = new HomeFragment();
                break;
            case R.id.drawer_person_item:
                fragment = new PersonFragment();
                break;
            case R.id.drawer_attention_item:
                fragment = new AttentionFragment();
                break;
            case R.id.drawer_find_item:
                fragment = new FindFragment();
                break;
            case R.id.drawer_message_item:
                fragment = new MessageFragment();
                break;
            case R.id.drawer_schedule_item:
                fragment = new ScheduleFragment();
                break;
            case R.id.drawer_setting_item:
                fragment = new SettingFragment();
                break;
            case R.id.drawer_about_item:
                fragment = new AboutFragment();
                break;
            default:
                if(fragment == null){
                    throw new NullPointerException("fragment is null");
                }
                break;
        }
        return fragment;
    }
}
