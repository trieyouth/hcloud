package com.zero.hcloud.ui.fragment.find;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zero.hcloud.R;
import com.zero.hcloud.ui.fragment.BaseFragment;

/**
 * Created by MyLuffy on 2015/6/28.
 */
public class FindFragment extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View  view  = getCententView(inflater, R.layout.fragment_find);
        return view ;
    }
}
