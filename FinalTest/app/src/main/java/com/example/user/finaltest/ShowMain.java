package com.example.user.finaltest;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShowMain extends AppCompatActivity {

    FirebaseDatabase database;
    static DatabaseReference myRef;
    static ProAdapter proAdapter;

    static List<ProductModel> listpro;
    RecyclerView recyclerView;
    Button btnAdd, btnRes;
    String key;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_main);
        recyclerView = (RecyclerView) findViewById(R.id.id_recylerview);
        btnAdd = (Button) findViewById(R.id.id_btn_add);
        btnRes = (Button) findViewById(R.id.id_btn_refresh);
        listpro = new ArrayList<ProductModel>();

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ShowMain.this, AddPro.class));
            }
        });
        btnRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.removeValue();
                ShowMain.listpro = new ArrayList<ProductModel>();
                final Map<String, String> mMap = new HashMap<>();
                mMap.put("google_id", MainActivity.id);
                mMap.put("firebase_url", "https://final-1558424048521.firebaseio.com");
                new CallAPIAsyntask(mMap, ShowMain.this).execute("http://vidoandroid.vidophp.tk/api/FireBase/PushData");
            }
        });
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("AdvancedAndroidFinalTest");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    String key = dataSnapshot1.getKey();
                    ProductModel model = dataSnapshot1.getValue(ProductModel.class);
                    model.setKey(key);
                    listpro.add(model);
                    // Toast.makeText(MainActivity.this, myRef.getRef().toString(), Toast.LENGTH_SHORT).show();
                    proAdapter = new ProAdapter(listpro,  R.layout.detail_pro, ShowMain.this);
                    recyclerView.setAdapter(proAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(ShowMain.this, "Error!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
