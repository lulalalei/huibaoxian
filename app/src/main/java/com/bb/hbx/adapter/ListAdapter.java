package com.bb.hbx.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bb.hbx.R;
import com.bb.hbx.bean.XhbMsg;

import java.util.List;

/**
 * Created by Administrator on 2016/12/12.
 */

public class ListAdapter extends BaseAdapter {

    private List<XhbMsg> list;
    private LayoutInflater mInflater;


    public ListAdapter(Context context, List<XhbMsg> list) {
        this.list = list;
        this.mInflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public Object getItem(int position) {
        return list.get(position % list.size());
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHoler viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHoler();
            convertView = mInflater.inflate(R.layout.lv_content_item, null);
            viewHolder.tvText = (TextView) convertView.findViewById(R.id.tv);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHoler) convertView.getTag();
        }
        viewHolder.tvText.setText(list.get(position % list.size()).getMsgContent());

        return convertView;
    }

    static class ViewHoler {
        TextView tvText;
    }


}
