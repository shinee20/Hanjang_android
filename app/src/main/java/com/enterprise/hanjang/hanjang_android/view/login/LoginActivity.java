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
import com.enterprise.hanjang.hanjang_android.view.record.RecordActivity;
import com.enterprise.hanjang.hanjang_android.view.voca.VocaActivity;
import com.facebook.CallbackManager;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by shineeseo on 2018. 9. 12..
 */

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";

    private ImageView facebook_login_btn;
    private ImageView google_login_btn;
    private TextView go_without_login;

    // [START declare_auth]
    private FirebaseAuth mAuth;
    // [END declare_auth]

    private CallbackManager mCallbackManager;


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
                    Intent intent = new Intent(LoginActivity.this, RecordActivity.class);
                    startActivity(intent);
            }
        });
    }
}
