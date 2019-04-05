package com.example.user.endexam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

public class History extends AppCompatActivity {

    CustomAdapterTable adaptertab;
    List<Table> list;
    ListView listView;
    MySQLite sqLite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        sqLite = new MySQLite(History.this);

        listView = (ListView)findViewById(R.id.idLV_History);
        list = sqLite.getAllTableCoffee();
        adaptertab = new CustomAdapterTable(History.this, R.layout.detail_lv_table, list);
        listView.setAdapter(adaptertab);
    }
}
