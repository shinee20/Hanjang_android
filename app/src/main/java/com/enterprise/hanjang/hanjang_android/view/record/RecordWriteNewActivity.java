package com.enterprise.hanjang.hanjang_android.view.record;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.enterprise.hanjang.hanjang_android.R;
import com.enterprise.hanjang.hanjang_android.model.record.RecordTextValue;

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
    private TextView oval_color_1;
    private TextView oval_color_2;
    private TextView oval_color_3;
    private TextView oval_color_4;
    private TextView oval_color_5;
    private TextView oval_color_6;
    private TextView oval_color_7;
    private GradientDrawable gd;
    private int seek1_status, seek2_status, seek3_status;
    private static int seek1_pre_status = 0, seek2_pre_status = 0, seek3_pre_status= 0;

    public static RecordTextValue recordTextValue;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_record);

        linear_write_record = (LinearLayout) findViewById(R.id.linear_write_record);

        record_txt = (EditText) findViewById(R.id.record_txt);

        oval_selected_color = (TextView) findViewById(R.id.oval_selected_color);

        letterspacing_adj = (ImageView) findViewById(R.id.letterspacing_adj);

        linespacing_adj = (ImageView) findViewById(R.id.linespacing_adj);

        backgroundcolor_adj_white = (ImageView) findViewById(R.id.backgroundcolor_adj_white);

        backgroundcolor_adj_black = (ImageView) findViewById(R.id.backgroundcolor_adj_black);

        text_size_adj = (ImageView) findViewById(R.id.text_size_adj);

        oval_color_1 = (TextView) findViewById(R.id.oval_color_1);
        //동적으로 shape.xml의 색상 바꾸기
        gd = (GradientDrawable) oval_color_1.getBackground().getCurrent();
        gd.setColor(Color.parseColor("#e8d8bf"));

        oval_color_2 = (TextView) findViewById(R.id.oval_color_2);
        gd = (GradientDrawable) oval_color_2.getBackground().getCurrent();
        gd.setColor(Color.parseColor("#bea36b"));

        oval_color_3 = (TextView) findViewById(R.id.oval_color_3);
        gd = (GradientDrawable) oval_color_3.getBackground().getCurrent();
        gd.setColor(Color.parseColor("#393f71"));

        oval_color_4 = (TextView) findViewById(R.id.oval_color_4);
        gd = (GradientDrawable) oval_color_4.getBackground().getCurrent();
        gd.setColor(Color.parseColor("#f8755a"));

        oval_color_5 = (TextView) findViewById(R.id.oval_color_5);
        gd = (GradientDrawable) oval_color_5.getBackground().getCurrent();
        gd.setColor(Color.parseColor("#f19c90"));

        oval_color_6 = (TextView) findViewById(R.id.oval_color_6);
        gd = (GradientDrawable) oval_color_6.getBackground().getCurrent();
        gd.setColor(Color.parseColor("#52bdbb"));

        oval_color_7 = (TextView) findViewById(R.id.oval_color_7);
        gd = (GradientDrawable) oval_color_7.getBackground().getCurrent();
        gd.setColor(Color.parseColor("#dedede"));

        //선택한 색에 따라서 view background 색과 oval_select_color의 색을 바꾸기
        gd = (GradientDrawable) oval_selected_color.getBackground().getCurrent();
        oval_color_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linear_write_record.setBackgroundColor(Color.parseColor("#e8d8bf"));
                gd.setColor(Color.parseColor("#e8d8bf"));
            }
        });
        oval_color_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linear_write_record.setBackgroundColor(Color.parseColor("#bea36b"));
                gd.setColor(Color.parseColor("#bea36b"));
            }
        });
        oval_color_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linear_write_record.setBackgroundColor(Color.parseColor("#393f71"));
                gd.setColor(Color.parseColor("#393f71"));
            }
        });
        oval_color_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linear_write_record.setBackgroundColor(Color.parseColor("#f8755a"));
                gd.setColor(Color.parseColor("#f8755a"));
            }
        });
        oval_color_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linear_write_record.setBackgroundColor(Color.parseColor("#f19c90"));
                gd.setColor(Color.parseColor("#f19c90"));
            }
        });
        oval_color_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linear_write_record.setBackgroundColor(Color.parseColor("#52bdbb"));
                gd.setColor(Color.parseColor("#52bdbb"));
            }
        });
        oval_color_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linear_write_record.setBackgroundColor(Color.parseColor("#dedede"));
                gd.setColor(Color.parseColor("#dedede"));
            }
        });

        oval_selected_color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag == 0) {
                    text_size_adj.setVisibility(View.INVISIBLE);
                    letterspacing_adj.setVisibility(View.INVISIBLE);
                    linespacing_adj.setVisibility(View.INVISIBLE);
                    backgroundcolor_adj_white.setVisibility(View.INVISIBLE);
                    backgroundcolor_adj_black.setVisibility(View.INVISIBLE);

                    oval_color_1.setVisibility(View.VISIBLE);
                    oval_color_2.setVisibility(View.VISIBLE);
                    oval_color_3.setVisibility(View.VISIBLE);
                    oval_color_4.setVisibility(View.VISIBLE);
                    oval_color_5.setVisibility(View.VISIBLE);
                    oval_color_6.setVisibility(View.VISIBLE);
                    oval_color_7.setVisibility(View.VISIBLE);

                    flag = 1;
                } else {
                    text_size_adj.setVisibility(View.VISIBLE);
                    letterspacing_adj.setVisibility(View.VISIBLE);
                    linespacing_adj.setVisibility(View.VISIBLE);
                    backgroundcolor_adj_white.setVisibility(View.VISIBLE);
                    backgroundcolor_adj_black.setVisibility(View.VISIBLE);

                    oval_color_1.setVisibility(View.INVISIBLE);
                    oval_color_2.setVisibility(View.INVISIBLE);
                    oval_color_3.setVisibility(View.INVISIBLE);
                    oval_color_4.setVisibility(View.INVISIBLE);
                    oval_color_5.setVisibility(View.INVISIBLE);
                    oval_color_6.setVisibility(View.INVISIBLE);
                    oval_color_7.setVisibility(View.INVISIBLE);
                    flag = 0;
                }
            }
        });


        seekBar1 = (SeekBar) findViewById(R.id.seekBar1);
        seekBar2 = (SeekBar) findViewById(R.id.seekBar2);
        seekBar3 = (SeekBar) findViewById(R.id.seekBar3);

        recordTextValue = new RecordTextValue(record_txt.getTextSize(),record_txt.getLetterSpacing(),record_txt.getLineSpacingExtra());

        text_size_adj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag == 0) {
                    letterspacing_adj.setVisibility(View.INVISIBLE);
                    linespacing_adj.setVisibility(View.INVISIBLE);
                    backgroundcolor_adj_white.setVisibility(View.INVISIBLE);
                    backgroundcolor_adj_black.setVisibility(View.INVISIBLE);

                    seekBar1.setVisibility(View.VISIBLE);

                    //seekbar 조절에 따라서 text size 변경
                    seekBar1.setOnSeekBarChangeListener(seekBarChangeListener);
                    flag = 1;
                } else {
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

                    seekBar2.setOnSeekBarChangeListener(seekBarChangeListener);
                    flag = 1;
                } else {
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

                    seekBar3.setOnSeekBarChangeListener(seekBarChangeListener);
                    flag = 1;
                } else {
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
//                linear_write_record.setBackgroundColor(Color.parseColor("#ffffff"));
                record_txt.setTextColor(Color.parseColor("#ffffff"));
            }
        });

        backgroundcolor_adj_black.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                linear_write_record.setBackgroundColor(Color.parseColor("#000000"));
                record_txt.setTextColor(Color.parseColor("#000000"));
            }
        });


    }

    private SeekBar.OnSeekBarChangeListener seekBarChangeListener
            = new SeekBar.OnSeekBarChangeListener() {

        public void onProgressChanged(SeekBar seekBar, int progress,
                                      boolean fromUser) {

            switch (seekBar.getId()) {
                case R.id.seekBar1:
                    updateFontStatus(1);
                    break;
                case R.id.seekBar2:
                    updateFontStatus(2);
                    break;
                case R.id.seekBar3:
                    updateFontStatus(3);
                    break;
            }
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    };

    private void updateFontStatus(int seek_identi) {
        switch (seek_identi) {
            case 1:
                seek1_status = seekBar1.getProgress();
                if (seek1_status == 0) {
                    record_txt.setTextSize((float)47/ getResources().getDisplayMetrics().scaledDensity);
                }
                else if (seek1_pre_status < seek1_status)
                    record_txt.setTextSize(TypedValue.COMPLEX_UNIT_PX, (record_txt.getTextSize() + seek1_status));
                else
                    record_txt.setTextSize(TypedValue.COMPLEX_UNIT_PX, (record_txt.getTextSize() - seek1_status));
                seek1_pre_status = seek1_status;
                break;
            case 2:
                seek2_status = seekBar2.getProgress();
                if (seek2_status == 0) {
                    record_txt.setLetterSpacing(recordTextValue.getRecord_txt_letter_spacing());
                }
                else if (seek2_pre_status < seek2_status) {
                    record_txt.setLetterSpacing((float) ((record_txt.getLetterSpacing() + seek2_status) / 50));
                } else {
                    record_txt.setLetterSpacing((float) ((record_txt.getLetterSpacing() - seek2_status) / 50));
                }

                seek2_pre_status = seek2_status;
                break;
            case 3:
                seek3_status = seekBar3.getProgress();
                if (seek3_status == 0) {
                    record_txt.setLineSpacing(recordTextValue.getRecord_txt_line_spacing(), 1.0f);
                }
                else if (seek3_pre_status < seek3_status) {
                    record_txt.setLineSpacing((float) (record_txt.getLineSpacingExtra() + seek3_status / 10), 1.0f);
                } else {
                    record_txt.setLineSpacing((float) (record_txt.getLineSpacingExtra() - seek3_status / 10), 1.0f);
                }
                seek3_pre_status = seek3_status;
                break;

        }

    }
}
