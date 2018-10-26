package com.enterprise.hanjang.hanjang_android.view.voca.adapter;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.enterprise.hanjang.hanjang_android.MainActivity;
import com.enterprise.hanjang.hanjang_android.R;
import com.enterprise.hanjang.hanjang_android.model.record.RecordItem;
import com.enterprise.hanjang.hanjang_android.view.voca.VocaActivity;

import java.util.ArrayList;

import static com.enterprise.hanjang.hanjang_android.view.voca.VocaActivity.VOCA_RECTANGLE_BACKGROUND;


/**
 * Created by shineeseo on 2018. 9. 13..
 */

public class VocaPagerAdapter extends PagerAdapter {
    private LayoutInflater inflater;
    private View voca_rectangle;
    private TextView voca_order;
    public ImageView voca_regist_btn;
    public int flag = 0;
    public Toast toast;
    public Context mContext;
    public ArrayList<RecordItem> recordItemList;
    public TextView voca_title;
    public TextView voca_mean_first;
    public TextView voca_mean_second;
    public TextView voca_mean_third;
    public TextView voca_mean_forth;

    public TextView voca_date;

    public VocaPagerAdapter(Context mContext, ArrayList<RecordItem> recordItemList, LayoutInflater inflater) {

        // TODO Auto-generated constructor stub
        this.mContext = mContext;
        this.recordItemList = recordItemList;
        //전달 받은 LayoutInflater를 멤버변수로 전달

        this.inflater=inflater;

    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }

//PagerAdapter가 가지고 잇는 View의 개수를 리턴

    //보통 보여줘야하는 이미지 배열 데이터의 길이를 리턴

    @Override

    public int getCount() {

        // TODO Auto-generated method stub

        return recordItemList.size(); //이미지 개수 리턴(그림이 10개라서 10을 리턴)

    }


    //ViewPager가 현재 보여질 Item(View객체)를 생성할 필요가 있는 때 자동으로 호출

    //쉽게 말해, 스크롤을 통해 현재 보여져야 하는 View를 만들어냄.

    //첫번째 파라미터 : ViewPager

    //두번째 파라미터 : ViewPager가 보여줄 View의 위치(가장 처음부터 0,1,2,3...)

    @Override

    public Object instantiateItem(ViewGroup container, int position) {

        // TODO Auto-generated method stub

        View view=null;

        //새로운 View 객체를 Layoutinflater를 이용해서 생성

        //만들어질 View의 설계는 res폴더>>layout폴더>>viewpater_childview.xml 레이아웃 파일 사용

        view= inflater.inflate(R.layout.voca_viewpager_childview, null);

        voca_rectangle = (View) view.findViewById(R.id.voca_rectangle);
        voca_title = (TextView)view.findViewById(R.id.voca_title);
        voca_mean_first = (TextView)view.findViewById(R.id.voca_mean_first);
        voca_mean_second = (TextView)view.findViewById(R.id.voca_mean_second);
        voca_mean_third = (TextView)view.findViewById(R.id.voca_mean_third);
        voca_mean_forth = (TextView)view.findViewById(R.id.voca_mean_forth);

        voca_date = (TextView)view.findViewById(R.id.voca_date);

        if (position < 7)
            voca_rectangle.setBackgroundResource(VOCA_RECTANGLE_BACKGROUND[position]);


        voca_order = (TextView) view.findViewById(R.id.voca_order);

        String s = String.format("%02d", position + 1);

        voca_order.setText(s);


        voca_regist_btn = (ImageView)view.findViewById(R.id.voca_regist_btn);

        voca_title.setText(recordItemList.get(position).getRecord_title());

        String record_mean = recordItemList.get(position).getRecord_mean();

        String[] mean_split = record_mean.split(" ");

        String a = "";
        String b = "";
        String c = "";
        String d = "";
        for (int i = 0; i < mean_split.length; i++) {
            if (i < 4) {
                a = a.concat(mean_split[i] + " ");
                Log.v("a", a);
            }

            else if (i >= 4 && i < 8)
                b = b.concat(mean_split[i] + " ");

            else if (i >= 8 && i < 12)
                c = c.concat(mean_split[i] + " ");
            else
                d = d.concat(mean_split[i] + " ");

        }
        voca_mean_first.setText(a.replace(" ", "\u00A0"));
        voca_mean_second.setText(b.replace(" ", "\u00A0"));
        if (!c.equals("")) {
            voca_mean_third.setVisibility(View.VISIBLE);
            voca_mean_third.setText(c.replace(" ", "\u00A0"));
        }
        if (!d.equals("")) {
            voca_mean_forth.setVisibility(View.VISIBLE);
            voca_mean_forth.setText(d.replace(" ", "\u00A0"));
        }
        voca_date.setText(recordItemList.get(position).getRecord_date());

        view.setTag(position);

        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                int position=(Integer) view.getTag();

                final Dialog delete_voca_dialog = new Dialog(mContext);
                delete_voca_dialog.setContentView(R.layout.voca_delete_dialog_layout);
                delete_voca_dialog.setTitle("Delete Dialog");

                TextView delete_voca_title = (TextView) delete_voca_dialog.findViewById(R.id.delete_voca_title);
                delete_voca_title.setText("'" + recordItemList.get(position).getRecord_title() + "'");

                Button btn_bookmark_ok = (Button) delete_voca_dialog.findViewById(R.id.btn_bookmark_ok);

                btn_bookmark_ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast toast = Toast.makeText(mContext, "단어장에서 삭제되었습니다.", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER_HORIZONTAL, 0, -100);
                        toast.show();
                        delete_voca_dialog.dismiss();
                    }
                });
                Button btn_bookmark_cancel = (Button) delete_voca_dialog.findViewById(R.id.btn_bookmark_cancel);

                btn_bookmark_cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast toast = Toast.makeText(mContext, "삭제 동작을 취소합니다.", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER_HORIZONTAL, 0, -100);
                        toast.show();
                        delete_voca_dialog.dismiss();
                    }
                });

                delete_voca_dialog.show();
                return false;
            }
        });
        //ViewPager에 만들어 낸 View 추가

        container.addView(view);

        //Image가 세팅된 View를 리턴

        return view;

    }

    //화면에 보이지 않은 View는파쾨를 해서 메모리를 관리함.

    //첫번째 파라미터 : ViewPager

    //두번째 파라미터 : 파괴될 View의 인덱스(가장 처음부터 0,1,2,3...)

    //세번째 파라미터 : 파괴될 객체(더 이상 보이지 않은 View 객체)

    @Override

    public void destroyItem(ViewGroup container, int position, Object object) {

        // TODO Auto-generated method stub



        //ViewPager에서 보이지 않는 View는 제거

        //세번째 파라미터가 View 객체 이지만 데이터 타입이 Object여서 형변환 실시

        container.removeView((View)object);



    }



    //instantiateItem() 메소드에서 리턴된 Ojbect가 View가  맞는지 확인하는 메소드
    @Override

    public boolean isViewFromObject(View v, Object obj) {

        // TODO Auto-generated method stub

        return v==obj;

    }

    @Override
    public float getPageWidth(int position) {
        return (0.9f);
//        return super.getPageWidth(position);
    }

//    saveState() 상태에서 저장했던 Adapter와 page를 복구 한다.
    @Override public void restoreState(Parcelable arg0, ClassLoader arg1) {}

//    현재 UI 상태를 저장하기 위해 Adapter와 Page 관련 인스턴스 상태를 저장 합니다.
    @Override public Parcelable saveState() { return null; }

//    페이지 변경이 시작될때 호출 됩니다.
    @Override public void startUpdate(View arg0) {}

//    페이지 변경이 완료되었을때 호출 됩니다.
    @Override public void finishUpdate(View arg0) {}

}
