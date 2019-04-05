package com.example.user.endexam;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class TableFragment extends Fragment {
    static CustomAdapterTable adaptertab;
    static List<Table> arrTab;
    static ListView lvTab;
    Button btnCreate, btnHistory;
    //static MySQLite sqLite;
    View mView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

      //  sqLite = new MySQLite(getContext());
        arrTab = new ArrayList<Table>();
        //arrTab = sqLite.getAllTableCoffee();
        mView = inflater.inflate(R.layout.fragment_table, container, false);
        lvTab = mView.findViewById(R.id.idLvTable);

        adaptertab = new CustomAdapterTable(getContext(), R.layout.detail_lv_table, arrTab);
        lvTab.setAdapter(adaptertab);


        //arrTab = sqLite.getAllTableCoffee();

        btnCreate = mView.findViewById(R.id.id_btn_CREATE);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity().getApplication(), CreateTable.class);
                startActivity(intent);
            }
        });

        btnHistory = mView.findViewById(R.id.id_btnHistory);
        btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity().getApplication(), History.class);
                startActivity(intent);
            }
        });
        return mView;
    }


}
