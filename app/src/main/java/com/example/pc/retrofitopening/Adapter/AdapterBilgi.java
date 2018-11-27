package com.example.pc.retrofitopening.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.pc.retrofitopening.Models.Bilgiler;
import com.example.pc.retrofitopening.R;

import java.util.List;


public class AdapterBilgi extends BaseAdapter {

    List<Bilgiler> bilgilerList;
    Context context;

    public AdapterBilgi(List<Bilgiler> bilgilerList, Context context) {
        this.bilgilerList = bilgilerList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return bilgilerList.size();
    }

    @Override
    public Object getItem(int position) {
        return bilgilerList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.list_bilgiler, parent, false);

        TextView txtUserID = (TextView) convertView.findViewById(R.id.txtUserID);
        TextView txtID = (TextView) convertView.findViewById(R.id.txtID);
        TextView txtTitle = (TextView) convertView.findViewById(R.id.txtTitle);
        TextView txtBody = (TextView) convertView.findViewById(R.id.txtBody);

        txtUserID.setText(bilgilerList.get(position).getUserId());
        txtID.setText(bilgilerList.get(position).getId());
        txtTitle.setText(bilgilerList.get(position).getTitle());
        txtBody.setText(bilgilerList.get(position).getBody());

        return convertView;
    }
}
