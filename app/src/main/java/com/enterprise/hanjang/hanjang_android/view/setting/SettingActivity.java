package com.enterprise.hanjang.hanjang_android.view.setting;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.enterprise.hanjang.hanjang_android.R;
import com.enterprise.hanjang.hanjang_android.view.login.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

/**
 * Created by shineeseo on 2018. 10. 7..
 */

public class SettingActivity extends AppCompatActivity {
    private ListView setting_list_view;
    private ImageView setting_back_btn;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        TextView setting_id = (TextView)findViewById(R.id.setting_id);
        setting_id.setText(user.getEmail().toString());
//        setting_id.setText(user.getEmail());
        setting_list_view = (ListView) findViewById(R.id.setting_list_view);

        ArrayList<SettingListViewAdapter.ListItem> settingListItem = new ArrayList<>();

        settingListItem.add(new SettingListViewAdapter.ListItem("푸시 알람(새로운 단어 등록)"));
        settingListItem.add(new SettingListViewAdapter.ListItem("개발자 정보(문의하기)"));
        settingListItem.add(new SettingListViewAdapter.ListItem("버전 정보"));

        SettingListViewAdapter listViewAdapter = new SettingListViewAdapter(this, R.layout.setting_list_view, settingListItem);
        setting_list_view.setAdapter(listViewAdapter);

        setting_back_btn = (ImageView)findViewById(R.id.setting_back_btn);
        setting_back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        ImageView logout_btn = (ImageView)findViewById(R.id.logout_btn);

        logout_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(SettingActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });


    }
}
