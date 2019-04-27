package com.example.user.midterm_adv;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Detail_item extends AppCompatActivity {

    EditText edtName, edtPrice, edtId, edtDes, edtProducer;
    Button btnDel, btnUp;
    int user_id = 0;
    int pro_id = 0;
    int pos=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_item);
        getID();
        onGetValue();
        pro_id = Integer.parseInt(edtId.getText().toString());
        user_id = PhoneActivity.pos;
        btnDel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                final Map<String, Integer> mMap = new HashMap<>();
                mMap.put("id",pro_id);
                mMap.put("user_id", user_id);
                Toast.makeText(Detail_item.this, ""+pro_id, Toast.LENGTH_SHORT).show();
                new PhoneAsynctask(mMap).execute("http://www.vidophp.tk/api/account/dataaction?context=delete");
                finish();
            }
        });




    }


    private void onGetValue() {
        Intent intent = getIntent();
      //  position = intent.getIntExtra("POS",0);
        Phone item = (Phone) intent.getSerializableExtra("Detail");
        edtId.setText(String.valueOf(item.getId()));
        edtProducer.setText(item.getProDucer());
        edtPrice.setText(String.valueOf(item.getProPrice()));
        edtDes.setText(item.getProDes());
        edtName.setText(item.getProName());

    }
    private void getID() {
        edtName = findViewById(R.id.id_detail_name);
        edtDes = findViewById(R.id.id_detail_des);
        edtId = findViewById(R.id.id_detail_id);
        edtPrice = findViewById(R.id.id_detail_price);
        edtProducer = findViewById(R.id.id_detail_producer);
        btnUp = findViewById(R.id.id_btn_update);
        btnDel = findViewById(R.id.id_btn_del);
    }
}
