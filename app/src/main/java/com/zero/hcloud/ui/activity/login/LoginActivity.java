package com.zero.hcloud.ui.activity.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.zero.hcloud.R;
import com.zero.hcloud.ui.activity.BaseActivity;
import com.zero.hcloud.ui.activity.MainActivity;
import com.zero.hcloud.util.StatusBarCompat;


/**
 * Created by youth on 2015/11/17.
 */
public class LoginActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        StatusBarCompat.compat(this, getResources().getColor(R.color.slide_color2));
        findViewById(R.id.user_login_login_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

}
