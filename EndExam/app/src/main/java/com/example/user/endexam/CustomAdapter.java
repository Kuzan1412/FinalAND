package com.example.user.endexam;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends BaseAdapter {

    Context mycontext;
    int mylayout;
    static  List<Product> mylist;


    public CustomAdapter(Context mycontext, int mylayout, List<Product> mylist) {
        this.mycontext = mycontext;
        this.mylayout = mylayout;
        this.mylist = mylist;

    }

    @Override
    public int getCount() {
        return mylist.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mycontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(mylayout, null);

        TextView txtName = (TextView) convertView.findViewById(R.id.idtxtProName);
        txtName.setText(String.valueOf(mylist.get(position).getNamePro()));

        TextView txtCode = (TextView) convertView.findViewById(R.id.idtxtProCode);
        txtCode.setText(String.valueOf(mylist.get(position).getCodePro()));

        TextView txtCost = (TextView) convertView.findViewById(R.id.idtxtProCost);
        txtCost.setText(String.valueOf(mylist.get(position).getCostPro()));

        TextView txtUnit = (TextView) convertView.findViewById(R.id.idtxtProUnit);
        txtUnit.setText(String.valueOf(mylist.get(position).getUnitPro()));


        Intent intent = new Intent(mycontext, PayMent.class);
        intent.putExtra("Pro", 0);
        return convertView;
    }
}
