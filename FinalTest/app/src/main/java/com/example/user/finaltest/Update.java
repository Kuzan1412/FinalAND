package com.example.user.finaltest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class Update extends AppCompatActivity {
    Button btnAcc;
    EditText edtName, edtDes, edtPrice, edtProducer;
    TextView txtId;


    String proname = "", prodes = "", proproducer = "", proprice = "";
    String keyId = "";
    private void onGetIntent()
    {
        Intent intent = getIntent();
        final ProductModel item = (ProductModel) intent.getSerializableExtra("DataUp");
        txtId.setText(String.valueOf(item.getId()));

        edtDes.setText(item.getDescription());
        edtPrice.setText(String.valueOf(item.getPrice()));
        edtName.setText(item.getProduct_name());
        edtProducer.setText(item.getProducer());
        keyId = item.getKey();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        run();
        onGetIntent();
        btnAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ValidateForm()) {

                    ShowMain.myRef.child(keyId).child("id").setValue(Integer.parseInt(txtId.getText().toString()));
                    ShowMain.myRef.child(keyId).child("product_name").setValue(proname);
                    ShowMain.myRef.child(keyId).child("description").setValue(prodes);
                    ShowMain.myRef.child(keyId).child("price").setValue(Integer.parseInt(proprice));
                    ShowMain.myRef.child(keyId).child("producer").setValue(proproducer);

                    ShowMain.listpro = new ArrayList<ProductModel>();
                    ShowMain.proAdapter.notifyDataSetChanged();
                    finish();
                }
            }
        });
    }

    private boolean ValidateForm()
    {
        proname = edtName.getText().toString();
        prodes = edtDes.getText().toString();
        proprice = edtPrice.getText().toString();
        proproducer = edtProducer.getText().toString();
        if(proname.length() > 1)
        {
            return true;
        }
        if(prodes.length() > 1)
            return true;
        if(proproducer.length() > 1)
        {
            return true;
        }
        if(proprice.length() > 1)
        {
            return true;
        }
        return false;
    }
    private void run() {
        btnAcc = findViewById(R.id.id_btn_Accept);
        edtProducer = findViewById(R.id.id_edt_up_producder);
        edtDes = findViewById(R.id.id_edt_up_desc);
        edtName = findViewById(R.id.id_edt_up_name);
        edtPrice = findViewById(R.id.id_edt_up_price);
        txtId = findViewById(R.id.id_edt_up_id);
    }
}
