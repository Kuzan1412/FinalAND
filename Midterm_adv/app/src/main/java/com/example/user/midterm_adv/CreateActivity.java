package com.example.user.midterm_adv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashMap;
import java.util.Map;

public class CreateActivity extends AppCompatActivity {

    EditText edtName, edtPrice, edtId, edtDes, edtProducer;
    Button btnAcc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        getID();
        btnAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Map<String, String> mMap = new HashMap<>();
                mMap.put("id", edtId.getText().toString());
                mMap.put("name", edtName.getText().toString());
                mMap.put("number", edtPrice.getText().toString());
                mMap.put("code", edtProducer.getText().toString());
                mMap.put("description", edtDes.getText().toString());
                new AddAsynctask(mMap).execute("http://www.vidophp.tk/api/account/dataaction?context=insert");
                finish();
            }
        });
    }

    private void getID() {
        edtName = findViewById(R.id.id_create_name);
        edtDes = findViewById(R.id.id_create_des);
        edtProducer = findViewById(R.id.id_create_producer);
        edtPrice = findViewById(R.id.id_create_price);
        edtId = findViewById(R.id.id_create_id);
        btnAcc = findViewById(R.id.id_btn_accept);
    }
}
