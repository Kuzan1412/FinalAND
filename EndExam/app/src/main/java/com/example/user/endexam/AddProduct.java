package com.example.user.endexam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class AddProduct extends AppCompatActivity {
    EditText edtName, edtCode, edtCost;

    MySQLite sqLite;
    Button btnSave;
    String mName = "", mCode = "", mUnit = "VND", mCost = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        run();
        sqLite = new MySQLite(AddProduct.this);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(CheckData())
                {
                    final Product product = new Product(mCode, mName, mCost, mUnit);
                    sqLite.addProduct(mName, mCode, mCost, mUnit);
                    ProductFragment.arrSystem.add(product);
                    ProductFragment.adapter.notifyDataSetChanged();
                    Toast.makeText(AddProduct.this, "Successful", Toast.LENGTH_SHORT).show();
                    ClearData();
                }
            }
        });
    }

    private void ClearData()
    {
        edtCost.setText("");
        edtCode.setText("");
        edtName.setText("");
    }
    private boolean CheckData()
    {
        mName = edtName.getText().toString();
        mCode = edtCode.getText().toString();
        mCost = edtCost.getText().toString();

        if(mName.length() <1)
        {
            edtName.setError("Please fill full this row !");
            return false;
        }
        if(mCode.length() != 6)
        {
            edtCode.setError("Please fill full this row !");
            return false;
        }
        if(mCost.length() < 0)
        {
            edtCost.setError("Please fill full this row !");
            return false;
        }
        return true;
    }
    private void run() {
        edtName = findViewById(R.id.id_add_Name);
        edtCode = findViewById(R.id.id_add_Code);
        edtCost = findViewById(R.id.id_add_Cost);
        btnSave = findViewById(R.id.id_btn_SAVE);
    }
}
