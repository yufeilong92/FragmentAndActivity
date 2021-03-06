package com.xuechuan.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.xuechuan.myapplication.R;

import java.util.List;

/**
 * @version V 1.0 xxxxxxxx
 * @Title: demo
 * @Package com.xuechuan.myapplication.adapter
 * @Description: todo
 * @author: L-BackPacker
 * @date: 2018/9/10 9:11
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2018
 */
public class TitmeAdapter extends BaseAdapter {
    private Context mContext;
    private List<String> mData;

    public TitmeAdapter(Context mContext, List<String> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.mTvTime.setText(mData.get(position));
        return convertView;
    }

    public static class ViewHolder {
        public View rootView;
        public TextView mTvTime;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.mTvTime = (TextView) rootView.findViewById(R.id.tv_time);
        }

    }
}
