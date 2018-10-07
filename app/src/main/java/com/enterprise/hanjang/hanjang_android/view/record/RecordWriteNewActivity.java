package com.enterprise.hanjang.hanjang_android.view.record;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.enterprise.hanjang.hanjang_android.R;

import org.w3c.dom.Text;

/**
 * Created by shineeseo on 2018. 10. 2..
 */

public class RecordWriteNewActivity extends AppCompatActivity {
    private TextView oval_selected_color;
    private ImageView text_size_adj;
    private ImageView letterspacing_adj;
    private ImageView linespacing_adj;
    private ImageView backgroundcolor_adj_white;
    private ImageView backgroundcolor_adj_black;
    private EditText record_txt;
    private SeekBar seekBar1;
    private SeekBar seekBar2;
    private SeekBar seekBar3;
    private int flag = 0;
    private RelativeLayout.LayoutParams lp;
    private LinearLayout linear_write_record;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_record);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        linear_write_record = (LinearLayout)findViewById(R.id. linear_write_record);

        record_txt = (EditText) findViewById(R.id.record_txt);

        oval_selected_color = (TextView) findViewById(R.id.oval_selected_color);

        letterspacing_adj = (ImageView) findViewById(R.id.letterspacing_adj);

        linespacing_adj = (ImageView) findViewById(R.id.linespacing_adj);

        backgroundcolor_adj_white = (ImageView) findViewById(R.id.backgroundcolor_adj_white);

        backgroundcolor_adj_black = (ImageView) findViewById(R.id.backgroundcolor_adj_black);

        text_size_adj = (ImageView) findViewById(R.id.text_size_adj);

        seekBar1 = (SeekBar) findViewById(R.id.seekBar1);
        seekBar2 = (SeekBar) findViewById(R.id.seekBar2);
        seekBar3 = (SeekBar) findViewById(R.id.seekBar3);

        text_size_adj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag == 0) {
                    letterspacing_adj.setVisibility(View.INVISIBLE);
                    linespacing_adj.setVisibility(View.INVISIBLE);
                    backgroundcolor_adj_white.setVisibility(View.INVISIBLE);
                    backgroundcolor_adj_black.setVisibility(View.INVISIBLE);

                    seekBar1.setVisibility(View.VISIBLE);
                    flag = 1;
                }
                else {
                    letterspacing_adj.setVisibility(View.VISIBLE);
                    linespacing_adj.setVisibility(View.VISIBLE);
                    backgroundcolor_adj_white.setVisibility(View.VISIBLE);
                    backgroundcolor_adj_black.setVisibility(View.VISIBLE);

                    seekBar1.setVisibility(View.INVISIBLE);
                    flag = 0;
                }

            }
        });
        letterspacing_adj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lp = (RelativeLayout.LayoutParams) letterspacing_adj.getLayoutParams();

                if (flag == 0) {
                    text_size_adj.setVisibility(View.INVISIBLE);
                    linespacing_adj.setVisibility(View.INVISIBLE);
                    backgroundcolor_adj_white.setVisibility(View.INVISIBLE);
                    backgroundcolor_adj_black.setVisibility(View.INVISIBLE);

                    //버튼 클릭시 색 변경 버튼 옆에 위치하도록 한다
                    lp.addRule(RelativeLayout.ALIGN_PARENT_LEFT, 0);
                    lp.addRule(RelativeLayout.RIGHT_OF, oval_selected_color.getId());
                    letterspacing_adj.setLayoutParams(lp);

                    seekBar2.setVisibility(View.VISIBLE);
                    flag = 1;
                }
                else {
                    text_size_adj.setVisibility(View.VISIBLE);
                    linespacing_adj.setVisibility(View.VISIBLE);
                    backgroundcolor_adj_white.setVisibility(View.VISIBLE);
                    backgroundcolor_adj_black.setVisibility(View.VISIBLE);

                    //위치 원래대로
                    lp.addRule(RelativeLayout.ALIGN_PARENT_LEFT, 0);
                    lp.addRule(RelativeLayout.RIGHT_OF, text_size_adj.getId());
                    letterspacing_adj.setLayoutParams(lp);
                    seekBar2.setVisibility(View.INVISIBLE);
                    flag = 0;
                }

            }
        });
        linespacing_adj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lp = (RelativeLayout.LayoutParams) linespacing_adj.getLayoutParams();
                if (flag == 0) {
                    letterspacing_adj.setVisibility(View.INVISIBLE);
                    text_size_adj.setVisibility(View.INVISIBLE);
                    backgroundcolor_adj_white.setVisibility(View.INVISIBLE);
                    backgroundcolor_adj_black.setVisibility(View.INVISIBLE);

                    //버튼 클릭시 색 변경 버튼 옆에 위치하도록 한다
                    lp.addRule(RelativeLayout.ALIGN_PARENT_LEFT, 0);
                    lp.addRule(RelativeLayout.RIGHT_OF, oval_selected_color.getId());
                    linespacing_adj.setLayoutParams(lp);
                    seekBar3.setVisibility(View.VISIBLE);
                    flag = 1;
                }
                else {
                    letterspacing_adj.setVisibility(View.VISIBLE);
                    text_size_adj.setVisibility(View.VISIBLE);
                    backgroundcolor_adj_white.setVisibility(View.VISIBLE);
                    backgroundcolor_adj_black.setVisibility(View.VISIBLE);

                    //위치 원래대로
                    lp.addRule(RelativeLayout.ALIGN_PARENT_LEFT, 0);
                    lp.addRule(RelativeLayout.RIGHT_OF, letterspacing_adj.getId());
                    linespacing_adj.setLayoutParams(lp);
                    seekBar3.setVisibility(View.INVISIBLE);
                    flag = 0;
                }

            }
        });

        backgroundcolor_adj_white.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linear_write_record.setBackgroundColor(Color.parseColor("#ffffff"));

            }
        });

        backgroundcolor_adj_black.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linear_write_record.setBackgroundColor(Color.parseColor("#000000"));
            }
        });


    }
}
