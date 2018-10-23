package com.enterprise.hanjang.hanjang_android;

import android.content.Intent;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.enterprise.hanjang.hanjang_android.model.word.WordData;
import com.enterprise.hanjang.hanjang_android.model.word.WordResponse;
import com.enterprise.hanjang.hanjang_android.network.ApplicationController;
import com.enterprise.hanjang.hanjang_android.network.NetworkService;
import com.enterprise.hanjang.hanjang_android.view.record.RecordActivity;
import com.enterprise.hanjang.hanjang_android.view.record.RecordWriteNewActivity;
import com.enterprise.hanjang.hanjang_android.view.setting.SettingActivity;
import com.enterprise.hanjang.hanjang_android.view.voca.VocaActivity;
import com.google.android.gms.flags.impl.DataUtils;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.hello.seoulnuri.utils.SharedPreference;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout mDrawerLayout;
    private Intent intent;
    private ImageView menu_btn;
    private NavigationView navigationView;
    private ImageView drawer_close_btn;
    private FloatingActionButton fab_to_write;
    private FloatingActionButton fab_to_voca;
    private ImageView voca_regist_btn;
    private int flag = 0;
    private Toast toast;
    private TextView main_action_bar_title;
    private NetworkService networkService;
    private WordData todayWord;
    private TextView today_word_title;
    private TextView today_word_mean1;
    private TextView today_word_mean2;
    private TextView today_word_mean3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        networkService = ApplicationController.Companion.getInstance().getNetworkService();
        SharedPreference.Companion.getInstance();

        Networking();

        today_word_title = (TextView) findViewById(R.id.today_word_title);
        today_word_mean1 = (TextView) findViewById(R.id.today_word_mean1);
        today_word_mean2 = (TextView) findViewById(R.id.today_word_mean2);
        today_word_mean3 = (TextView) findViewById(R.id.today_word_mean3);

        long now = System.currentTimeMillis();
        Date date = new Date(now);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        String getTime = sdf.format(date);

        main_action_bar_title = (TextView) findViewById(R.id.main_action_bar_title);

        main_action_bar_title.setText(getTime);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        navigationView = (NavigationView) findViewById(R.id.navigation_view);

        View nav_header_view = navigationView.getHeaderView(0);

        //navigation drawer menu 버튼
        menu_btn = (ImageView) findViewById(R.id.menu_btn);

        menu_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v("click", "click");

                mDrawerLayout.openDrawer(Gravity.LEFT);

            }
        });

        navigationView.setNavigationItemSelectedListener(MainActivity.this);

        TextView nav_user_id = (TextView) nav_header_view.findViewById(R.id.nav_user_id);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        Log.v("user email", user.getEmail() + "");
        nav_user_id.setText(String.valueOf(user.getEmail()));
        drawer_close_btn = (ImageView) nav_header_view.findViewById(R.id.drawer_close_btn);

        drawer_close_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawerLayout.closeDrawer(Gravity.LEFT);
            }
        });

        voca_regist_btn = (ImageView) findViewById(R.id.voca_regist_btn);

        //즐겨찾기 버튼
        voca_regist_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag == 0) {
                    voca_regist_btn.setBackgroundResource(R.drawable.star_fill);
                    flag = 1;
                    toast = Toast.makeText(MainActivity.this, "단어장에 저장되었습니다", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER_HORIZONTAL, 0, -100);
                    toast.show();
                } else {
                    voca_regist_btn.setBackgroundResource(R.drawable.star);
                    flag = 0;

                    toast = Toast.makeText(MainActivity.this, "단어장에서 삭제되었습니다", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER_HORIZONTAL, 0, -100);
                    toast.show();
                }
            }
        });

        //글쓰기 floatingaction button
        fab_to_write = (FloatingActionButton) findViewById(R.id.fab_to_write);

        fab_to_write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RecordWriteNewActivity.class);
                startActivity(intent);
            }
        });

        //단어장 floatingaction button
        fab_to_voca = (FloatingActionButton) findViewById(R.id.fab_to_voca);

        fab_to_voca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, VocaActivity.class);
                startActivity(intent);
            }
        });


    }

    public void Networking() {
//        Call<BaseModel> requestDetail = networkService.registCourseBookmark(SharedPreference.Companion.getInstance().getPrefStringData("data"), courseDetailData.getCourse_idx());

        Call<WordResponse> requestDetail = networkService.getTodayWord();

        requestDetail.enqueue(new Callback<WordResponse>() {
            @Override
            public void onResponse(Call<WordResponse> call, Response<WordResponse> response) {
                if (response.isSuccessful()) {
                    todayWord = new WordData(response.body().getWord_idx(), response.body().getWord_title(), response.body().getWord_desc());
                    Log.v("word code", response.code() + "");
                    Log.v("word status", response.message() + "");
                    Log.v("get word", todayWord.toString());

                    today_word_title.setText(todayWord.getWord_title());

                    String s = todayWord.getWord_desc();

                    int mean_length = s.length();
                    String[] mean_split = s.split("");

                    String a = "";
                    String b = "";
                    String c = "";
                    for (int i = 0; i < mean_split.length; i++) {
                        Log.v("mean_split", mean_split[i]);
                        if (i < 4)
                            a += mean_split[i];

                        else if (i < 8)
                            b += mean_split[i];

                        else
                            c += mean_split[i];

                    }
                    today_word_mean1.setText(a);
                    today_word_mean2.setText(b);
                    if (!c.equals("")) {
                        today_word_mean3.setVisibility(View.VISIBLE);
                        today_word_mean3.setText(c);
                    }

                }
            }

            @Override
            public void onFailure(Call<WordResponse> call, Throwable t) {
                Log.i("err", t.getMessage());
            }
        });
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        item.setChecked(true);

        int id = item.getItemId();
        switch (id) {
            case R.id.navigation_item_today_word:
                intent = new Intent(MainActivity.this, MainActivity.class);
                break;

            case R.id.navigation_item_voca:
                intent = new Intent(MainActivity.this, VocaActivity.class);
                break;

            case R.id.navigation_item_record:
                intent = new Intent(MainActivity.this, RecordActivity.class);
                break;
            case R.id.navigation_item_setting:
                intent = new Intent(MainActivity.this, SettingActivity.class);
                break;

        }

        startActivity(intent);
        return true;

    }
}
