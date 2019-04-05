package com.example.user.endexam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class InformationTable extends AppCompatActivity {

    TextView txtTName, txtStatus, txtQuatity;
    private void onGetIntent()
    {
        Intent intent = getIntent();
        Table item = (Table) intent.getSerializableExtra("Table");
        txtTName.setText(item.getTabName());
        txtQuatity.setText(item.getTabQuatity());
        txtStatus.setText(item.getTabStatus());
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_table);
        run();
        onGetIntent();
    }

    private void run() {
        txtTName = findViewById(R.id.id_detailIn_table_name);
        txtStatus = findViewById(R.id.id_detailIn_table_status);
        txtQuatity = findViewById(R.id.id_detailIn_table_quatity);
    }
}
