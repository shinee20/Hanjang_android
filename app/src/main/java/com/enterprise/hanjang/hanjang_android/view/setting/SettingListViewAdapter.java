package com.enterprise.hanjang.hanjang_android.view.setting;

import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.enterprise.hanjang.hanjang_android.R;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.CLIPBOARD_SERVICE;

/**
 * Created by shineeseo on 2018. 10. 7..
 */

public class SettingListViewAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<ListItem> settingListItem;
    private int layout;
    private LayoutInflater inflater;
    private Button btn_qna_ok;
    private Button btn_qna_cancel;
    private ImageView btn_clipboard;

    public SettingListViewAdapter(Context mContext, int layout, ArrayList<ListItem> settingListItem) {
        this.mContext = mContext;
        this.layout = layout;
        this.settingListItem = settingListItem;
        inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = inflater.inflate(layout, viewGroup, false);
            viewHolder = new ViewHolder(convertView);

            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        ListItem listviewitem = settingListItem.get(i);

        viewHolder.setting_list_txt.setText(listviewitem.getList_txt());

        final Dialog setting_qna_dialog = new Dialog(mContext);

        if (listviewitem.getList_txt().contains("푸시")) {
            viewHolder.setting_push_switch.setVisibility(View.VISIBLE);

        } else if (listviewitem.getList_txt().contains("버전")) {
            viewHolder.setting_version_info.setVisibility(View.VISIBLE);
        }
        else {
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    setting_qna_dialog.setContentView(R.layout.setting_qna_dialog_layout);
                    setting_qna_dialog.setTitle("문의하기");

                    btn_qna_ok = (Button)setting_qna_dialog.findViewById(R.id.btn_qna_ok);
                    btn_qna_cancel = (Button)setting_qna_dialog.findViewById(R.id.btn_qna_cancel);
                    btn_clipboard = (ImageView)setting_qna_dialog.findViewById(R.id.btn_clipboard);

                    btn_clipboard.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            ClipboardManager clipboardManager = (ClipboardManager)mContext.getSystemService(CLIPBOARD_SERVICE);
                            ClipData clipData = ClipData.newPlainText("hanjang_developer_email", "hanjang_developer@Hanjang.com");
                            clipboardManager.setPrimaryClip(clipData);
                            Toast toast = Toast.makeText(mContext, "클립보드에 저장되었습니다", Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER_HORIZONTAL, 0, -100);
                            toast.show();
                        }
                    });

                    btn_qna_ok.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            setting_qna_dialog.dismiss();
                        }
                    });
                    btn_qna_cancel.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            setting_qna_dialog.dismiss();
                        }
                    });
                    setting_qna_dialog.show();


                }
            });
        }
        return convertView;
    }
    private class ViewHolder {
        private TextView setting_list_txt;
        private Switch setting_push_switch;
        private TextView setting_version_info;
        private LinearLayout setting_linear_layout;

        public ViewHolder(View itemView){
            setting_list_txt = (TextView) itemView.findViewById(R.id.setting_list_txt);
            setting_push_switch = (Switch) itemView.findViewById(R.id.setting_push_switch);
            setting_version_info = (TextView) itemView.findViewById(R.id.setting_version_info);
        }
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
