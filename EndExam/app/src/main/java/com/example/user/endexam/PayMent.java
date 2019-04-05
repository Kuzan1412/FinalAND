package com.example.user.endexam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class PayMent extends AppCompatActivity {


    MySQLite sqLite;
    int position = 0;
    Button btnNR, btnR;
    TextView txtTName, txtCode, txtQuatity, txtPrice;

    private void onGetIntent() {
        Intent intent = getIntent();
        Table item = (Table) intent.getSerializableExtra("Payment");
        position = intent.getIntExtra("Pos", 0);
        txtTName.setText(item.getTabName());
        txtQuatity.setText(String.valueOf(item.getTabQuatity()));
        txtPrice.setText(String.valueOf(item.getSum()));
    }

    private void CheckData()
    {
        String mName = "", mCode = "CF3009";
        mName = txtTName.getText().toString();
        if(mName.equals("Coffee Joy"))
        {
            mCode = "CF3009";
           txtCode.setText(mCode);
        }
        if(mName.equals("Coffee Moka"))
        {
            mCode = "CF1999";
            txtCode.setText(mCode);

        }
        if(mName.equals("Coffee Latte"))
        {
            mCode = "CF0300";
            txtCode.setText(mCode);
        }
        if(mName.equals("Coffee Cherry"))
        {
            mCode = "CF0031";
            txtCode.setText(mCode);
        }
        if(mName.equals("Coffee Arabica"))
        {
            mCode = "CF0199";
           txtCode.setText(mCode);
        }


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_ment);
        run();
        sqLite = new MySQLite(PayMent.this);
        onGetIntent();
        CheckData();
        int m = Integer.parseInt(txtPrice.getText().toString());
        final Table item = new Table("Paid", txtTName.getText().toString(), txtQuatity.getText().toString(), m);
        sqLite.addTable(txtTName.getText().toString(), m, txtQuatity.getText().toString(), "Paid");
        btnNR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TableFragment.arrTab.remove(position);
                TableFragment.arrTab.add(position, item);
                TableFragment.adaptertab.notifyDataSetChanged();
                Toast.makeText(PayMent.this, "Thank you!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        btnR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TableFragment.arrTab.remove(position);
                TableFragment.adaptertab.notifyDataSetChanged();
                Toast.makeText(PayMent.this, "Thanks, See you later!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    private void run() {
        btnNR = findViewById(R.id.id_btn_NR);
        btnR = findViewById(R.id.id_btn_R);
        txtTName = findViewById(R.id.id_PayName);
        txtPrice = findViewById(R.id.id_PayCost);
        txtQuatity = findViewById(R.id.id_PayQuatity);
        txtCode = findViewById(R.id.id_PayCode);
    }


}
