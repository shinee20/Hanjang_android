package com.enterprise.hanjang.hanjang_android.view.record;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_record);

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
                letterspacing_adj.setVisibility(View.INVISIBLE);
                linespacing_adj.setVisibility(View.INVISIBLE);
                backgroundcolor_adj_white.setVisibility(View.INVISIBLE);
                backgroundcolor_adj_black.setVisibility(View.INVISIBLE);

                seekBar1.setVisibility(View.VISIBLE);
            }
        });


    }
}
