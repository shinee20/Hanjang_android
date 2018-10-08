package com.enterprise.hanjang.hanjang_android.view.record.adapter;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.enterprise.hanjang.hanjang_android.R;
import com.enterprise.hanjang.hanjang_android.model.record.RecordItem;

import java.util.ArrayList;

import static com.enterprise.hanjang.hanjang_android.view.voca.VocaActivity.VOCA_RECTANGLE_COLOR;

/**
 * Created by shineeseo on 2018. 10. 2..
 */

public class RecordAnotherViewAdapter extends RecyclerView.Adapter<RecordAnotherViewAdapter.ViewHolder> {

    Context context;
    ArrayList<RecordItem> recordItemArrayList;

    public RecordAnotherViewAdapter(Context context, ArrayList<RecordItem> recordItemArrayList) {
        super();
        this.context = context;
        this.recordItemArrayList = recordItemArrayList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.record_another_view, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        final RecordItem recordItem = recordItemArrayList.get(i);
        final int pos = i;
//        int height = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, viewHolder.record_another_mean.getMeasuredHeight(), viewHolder.record_another_mean.getResources().getDisplayMetrics());
//        ViewGroup.LayoutParams lp = (ViewGroup.LayoutParams) viewHolder.record_another_view.getLayoutParams();
//        lp.height = height;
//        viewHolder.record_another_view.setLayoutParams(lp);

        viewHolder.record_another_view.setBackgroundResource(VOCA_RECTANGLE_COLOR[pos]);
        viewHolder.record_another_date.setText(recordItem.getRecord_date());
        viewHolder.record_another_title.setText(recordItem.getRecord_title());
        viewHolder.record_another_mean.setText(recordItem.getRecord_mean());
        viewHolder.record_number.setText(pos + 1 + "");

        viewHolder.record_another_mean.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);

        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams)viewHolder.record_another_view.getLayoutParams();
        layoutParams.height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, viewHolder.record_another_mean.getMeasuredHeight()+200 , viewHolder.record_another_view.getResources().getDisplayMetrics());
        int textview_height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, viewHolder.record_another_mean.getMeasuredHeight(), viewHolder.record_another_mean.getResources().getDisplayMetrics());
        int height = viewHolder.record_another_mean.getLayout().getHeight();
        Log.v("height", height + "");
        Log.v("textview height",textview_height + "" );
        Log.v("view height",layoutParams.height + "" );

        viewHolder.record_another_view.requestLayout();

    }

    @Override
    public int getItemCount() {
        return recordItemArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView record_another_title;
        public TextView record_another_mean;
        public TextView record_number;
        public TextView record_another_date;
        public View record_another_view;

        public ViewHolder(View itemView) {
            super(itemView);
            record_another_view = (View) itemView.findViewById(R.id.record_another_view);
            record_another_date = (TextView) itemView.findViewById(R.id.record_another_date);
            record_number = (TextView) itemView.findViewById(R.id.record_number);
            record_another_mean = (TextView) itemView.findViewById(R.id.record_another_mean);
            record_another_title = (TextView) itemView.findViewById(R.id.record_another_title);

        }


    }


}
