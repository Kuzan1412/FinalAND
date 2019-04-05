package com.example.user.endexam;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainTabLayout extends AppCompatActivity {
    ViewPager vpMain;
    ListView lvProduct;
    TabLayout tblMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tab_layout);
        run();
        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
        adapter.addFragment( new ProductFragment(), "The List Product");
        adapter.addFragment(new TableFragment(), "The list table");
        vpMain.setAdapter(adapter);
    }

    private void run() {

        vpMain = findViewById(R.id.id_ViewPager);
        tblMain = findViewById(R.id.id_MainTabLayout);
        tblMain.setupWithViewPager(vpMain);
        lvProduct = findViewById(R.id.idLVProduct);
    }
}
