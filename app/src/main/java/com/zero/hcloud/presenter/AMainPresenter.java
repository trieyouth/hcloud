package com.zero.hcloud.presenter;

import com.zero.hcloud.model.IAMainModel;
import com.zero.hcloud.model.impl.AMainModelImpl;
import com.zero.hcloud.ui.IAMain;

/**
 * Created by MyLuffy on 2015/6/29.
 */

public class AMainPresenter {

    private IAMain view;
    private IAMainModel model;

    public AMainPresenter(IAMain view){
        this.view = view;
        model = new AMainModelImpl();
    }

    public void loadToolbarTitle(int resId){
        String title = model.getToolbarTitle(resId);
        view.setToolbarTitle(title);
    }

    public void loadFragment(int resId){
        view.changeFragment(model.getFragment(resId));
    }

}
