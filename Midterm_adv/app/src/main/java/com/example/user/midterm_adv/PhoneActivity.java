package com.example.user.midterm_adv;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneActivity extends AppCompatActivity {

    List<Phone> modelist;
    Button btnAdd;
    static int pos = 0;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);
        recyclerView = (RecyclerView) findViewById(R.id.id_recycleview);
        btnAdd = (Button) findViewById(R.id.id_btn_add);

        modelist = new ArrayList<>();
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PhoneActivity.this, CreateActivity.class));
            }
        });
        final Map<String, Integer> mMap = new HashMap<>();
        Intent intent = getIntent();
        pos = intent.getIntExtra("user_id",0);
        mMap.put("id", pos);
        new PhoneAsynctask(mMap,new IView() {
            @Override
            public void OnGetBitmapSuccess(Bitmap bitmap) {

            }

            @Override
            public void onGetDataSuccess(JSONArray jsonArray) {


                for (int i=0;i<jsonArray.length();i++){
                    try {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        Phone model = new Phone();
                        model.setProDes(jsonObject.getString("description"));
                        model.setProName(jsonObject.getString("product_name"));
                        model.setProPrice(Integer.valueOf(jsonObject.getString("price")));
                        model.setProDucer(jsonObject.getString("producer"));
                        model.setId(Integer.valueOf(jsonObject.getString("id")));
                        modelist.add(model);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                PhoneAdapter adapter = new PhoneAdapter(modelist, R.layout.phone_item, PhoneActivity.this);
                recyclerView.setAdapter(adapter);
            }
        }).execute("http://www.vidophp.tk/api/account/getdata");

    }
}
