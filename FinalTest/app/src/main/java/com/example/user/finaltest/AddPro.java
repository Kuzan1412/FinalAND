package com.example.user.finaltest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddPro extends AppCompatActivity {

    EditText edtId, edtName, edtProducer, edtDes, edtPrice;
    Button btnSave;
    ProductModel model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pro);
        getID();
        model = new ProductModel();
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Validate())
                {
                    model.setProduct_name(edtName.getText().toString());
                    model.setProducer(edtProducer.getText().toString());
                    model.setDescription(edtDes.getText().toString());
                    model.setId(Integer.parseInt(edtId.getText().toString()));
                    model.setPrice(Integer.parseInt(edtPrice.getText().toString()));
                    ShowMain.myRef.push().setValue(model);
                    Toast.makeText(AddPro.this, "Successful!", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
    }
    public boolean Validate()
    {
        String name = edtName.getText().toString();
        String des = edtDes.getText().toString();
        String producer =edtProducer.getText().toString();
        int id = Integer.parseInt(edtId.getText().toString());
        int price =Integer.parseInt(edtPrice.getText().toString());
        if(name.length() > 1)
        {
            return true;
        }

        if(producer.length() > 1)
        {
            return true;
        }
        if(price > 1)
        {
            return true;
        }
        if(des.length() > 1)
        {
            return true;
        }
        if(String.valueOf(id).length() > 1)
        {
            return true;
        }
        return false;
    }
    private void getID() {
        edtId = findViewById(R.id.id_edt_add_id);
        edtName = findViewById(R.id.id_edt_add_name);
        edtDes = findViewById(R.id.id_edt_add_desc);
        edtPrice = findViewById(R.id.id_edt_add_price);
        edtProducer = findViewById(R.id.id_edt_add_producder);
        btnSave = findViewById(R.id.id_btn_save);
    }
}


