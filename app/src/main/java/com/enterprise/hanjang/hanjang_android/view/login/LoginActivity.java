package com.enterprise.hanjang.hanjang_android.view.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.enterprise.hanjang.hanjang_android.MainActivity;
import com.enterprise.hanjang.hanjang_android.R;

/**
 * Created by shineeseo on 2018. 9. 12..
 */

public class LoginActivity extends AppCompatActivity {

    ImageView facebook_login_btn;
    ImageView google_login_btn;
    TextView go_without_login;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        facebook_login_btn = (ImageView) findViewById(R.id.facebook_login_btn);

        google_login_btn = (ImageView) findViewById(R.id.google_login_btn);

        go_without_login = (TextView) findViewById(R.id.go_without_login);

        go_without_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
            }
        });
    }
}
