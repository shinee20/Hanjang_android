package com.enterprise.hanjang.hanjang_android.view.setting;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.enterprise.hanjang.hanjang_android.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shineeseo on 2018. 10. 7..
 */

public class SettingListViewAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<ListItem> settingListItem;
    private int layout;
    private LayoutInflater inflater;

    public SettingListViewAdapter(Context mContext,int layout,ArrayList<ListItem> settingListItem) {
        this.mContext = mContext;
        this.layout = layout;
        this.settingListItem = settingListItem;
        inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return settingListItem.size();
    }

    @Override
    public Object getItem(int i) {
        return settingListItem.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {

        if(convertView==null){
            convertView=inflater.inflate(layout,viewGroup,false);
        }
        ListItem listviewitem=settingListItem.get(i);
//        ImageView icon=(ImageView)convertView.findViewById(R.id.imageview);
//        icon.setImageResource(listviewitem.getIcon());
        TextView setting_list_txt=(TextView)convertView.findViewById(R.id.setting_list_txt);
        setting_list_txt.setText(listviewitem.getList_txt());
        return convertView;
    }

    public static class ListItem {
        public String list_txt;

        public String getList_txt() {
            return list_txt;
        }

        public void setList_txt(String list_txt) {
            this.list_txt = list_txt;
        }

        public ListItem(String list_txt) {
            this.list_txt = list_txt;
        }
    }
}
