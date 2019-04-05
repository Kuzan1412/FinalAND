package com.example.user.endexam;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CreateTable extends AppCompatActivity {

    Product product;
    int mProductId;
    Spinner spnName;
    EditText edtQuatity, edtSum, edtStatus;
    Button btnCompletely;
    String mName = "";
    String mStatus = "Is Using";
    int mQuatity = 1;
    int mSum = 20000;

    static List<String> namePro;
    List<Table> tableList;
    List<Bill> bills;
   // MySQLite sqLite;
    //=========================================================
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_table);
        run();
       // sqLite = new MySQLite(CreateTable.this);

        //===============================================


        namePro = new ArrayList<String>();
        namePro.add("Coffee Latte");
        namePro.add("Coffee Moka");
        namePro.add("Coffee Joy");
        namePro.add("Coffee Cherry");
        namePro.add("Coffee Arabica");
        ArrayAdapter<String> daraAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,namePro);
        daraAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spnName.setAdapter(daraAdapter);
        spnName.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                getData();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        //==================================================



        btnCompletely.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getData())
                {
                    final Table table = new Table(mStatus, mName, String.valueOf(mQuatity), mSum);
                    TableFragment.arrTab.add(table);
                    TableFragment.adaptertab.notifyDataSetChanged();

                    finish();
            }}
        });

     }
    private void ClearData()
    {

        edtSum.setText("");
        edtStatus.setText("");
        edtQuatity.setText("1");
    }
    public boolean getData()
    {

        mName = spnName.getSelectedItem().toString();
        mQuatity = Integer.parseInt(edtQuatity.getText().toString());

        if(mName == "Coffee Joy")
    {
        mSum = 20000 * mQuatity;
        edtSum.setText(String.valueOf(mSum));
    }
        if(mName == "Coffee Moka")
        {
            mSum = 50000 * mQuatity;
            edtSum.setText(String.valueOf(mSum));

        }
        if(mName == "Coffee Latte")
        {
            mSum = 55000 * mQuatity;
            edtSum.setText(String.valueOf(mSum));
        }
        if(mName == "Coffee Cherry")
        {
            mSum = 83000 * mQuatity;
            edtSum.setText(String.valueOf(mSum));

        }

        if(mName == "Coffee Arabica")
        {
            mSum = 91000 * mQuatity;
            edtSum.setText(String.valueOf(mSum));
        }
        if(mName.length() < 1)
            return false;
        if(mQuatity < 1)
            return false;
        return true;


    }

    private void run() {
        btnCompletely = findViewById(R.id.id_btn_commpletely);
        spnName = findViewById(R.id.id_Spinner);
        edtQuatity = findViewById(R.id.id_create_quantity);
        edtSum = findViewById(R.id.id_create_sum);
        edtStatus = findViewById(R.id.id_create_status);
    }
}
