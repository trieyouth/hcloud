package com.zero.hcloud.app;

import android.app.Application;
import com.orhanobut.logger.Logger;
import com.zero.hcloud.R;

/**
 * Created by MyLuffy on 2015/6/27.
 */

public class App extends Application {

    private static final String TAG = "app";

    @Override
    public void onCreate(){
        Logger.i(TAG,"start");
        this.setTheme(R.style.Theme_MateralDesign1);
    }

}
