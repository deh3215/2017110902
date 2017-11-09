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
    //LayoutInflater inflater = LayoutInflater.from(context);
        ViewHolder holder;
        LayoutInflater inflator = LayoutInflater.from(context);
        if(view == null)    {
            view = inflator.inflate(R.layout.myitem, null);//解出Layout 解壓器,消耗資源
            holder = new ViewHolder();
            holder.name = (TextView)view.findViewById(R.id.textView);
            holder.statement = (TextView)view.findViewById(R.id.textView2);
            holder.img =(ImageView)view.findViewById(R.id.imageView);
            view.setTag(holder);//要加,不然listview滑動會當掉
            holder.name.setText(zooInfo[i].E_Name);
            holder.statement.setText(zooInfo[i].E_Info);
            Picasso.with(context).load(zooInfo[i].E_Pic_URL).into(holder.img);
        }   else    {
            holder = (ViewHolder) view.getTag();
        }
        return view;

    }

    static class ViewHolder
    {
        TextView name;
        ImageView img;
        TextView statement;
    }
}
