package com.example.a32150.a2017110902;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

/**
 * Created by 32150 on 2017/11/9.
 */

public class MyAdapter extends BaseAdapter {

    ZooInfo[] zooInfo;
    Context context;

    public MyAdapter(Context context, ZooInfo[] zooInfo)  {
        this.context = context;
        this.zooInfo = zooInfo;
    }

    @Override
    public int getCount() {
        return zooInfo.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
    LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.myitem, null);
        TextView tv = (TextView) v.findViewById(R.id.textView);
        tv.setText(zooInfo[i].E_Name);
        ImageView iv =(ImageView)v.findViewById(R.id.imageView);
        TextView tv1 = (TextView) v.findViewById(R.id.textView2);
        tv1.setText(zooInfo[i].E_Info);
        Picasso.with(context).load(zooInfo[i].E_Pic_URL).into(iv);
        return v;
    }

    static class ViewHolder
    {
        TextView tv;
        ImageView img;
        TextView tv1;
    }
}
