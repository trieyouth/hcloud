package com.zero.hcloud.model;

import android.support.v4.app.Fragment;

public interface IAMainModel {

    String getToolbarTitle(int resId);

    Fragment getFragment(int resId);

}