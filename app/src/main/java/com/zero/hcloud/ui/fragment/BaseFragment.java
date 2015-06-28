package com.zero.hcloud.ui.fragment;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by MyLuffy on 2015/6/27.
 */

public class BaseFragment extends Fragment {

    protected View getCententView(LayoutInflater inflater,int resId){
        return inflater.inflate(resId,null);
    }



}
