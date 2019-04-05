package com.example.user.endexam;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class CustomAdapterTable extends BaseAdapter {
    Context mycontext;
    int mylayout;
    List<Table> mylist;
    MySQLite SQLite;
    CustomAdapter customAdapter;
    public CustomAdapterTable(Context mycontext, int mylayout, List<Table> mylist) {
        this.mycontext = mycontext;
        this.mylayout = mylayout;
        this.mylist = mylist;
        SQLite = new MySQLite(mycontext);

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
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mycontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(mylayout, null);


        TextView txtTName = (TextView) convertView.findViewById(R.id.id_txt_DName_Table);
        txtTName.setText(String.valueOf(mylist.get(position).getTabName()));

        TextView txtQuatity =(TextView) convertView.findViewById(R.id.id_txt_DQuatity_Table);
        txtQuatity.setText(String.valueOf(mylist.get(position).getTabQuatity()));

        TextView txtStatus = (TextView) convertView.findViewById(R.id.id_txt_DStatus_Table);
        txtStatus.setText(String.valueOf(mylist.get(position).getTabStatus()));


        final Table item = mylist.get(position);
        LinearLayout linearLayout = (LinearLayout) convertView.findViewById(R.id.idLayoutTable);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(mycontext, InformationTable.class);
                intent.putExtra("Table", item);
                mycontext.startActivity(intent);
            }
        });

        Button btnPay = (Button) convertView.findViewById(R.id.id_btn_PAY);
        btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mycontext, PayMent.class);
                intent.putExtra("Payment", item);
                intent.putExtra("Pos", position);
                mycontext.startActivity(intent);
            }
        });

        Button btnDel = (Button) convertView.findViewById(R.id.id_btn_DELETE);
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TableFragment.arrTab.remove(item);
                TableFragment.adaptertab.notifyDataSetChanged();
            }
        });
        return convertView;
    }
}
