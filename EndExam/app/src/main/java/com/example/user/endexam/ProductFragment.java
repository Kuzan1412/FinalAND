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


public class ProductFragment extends Fragment {
    static CustomAdapter adapter;
    static List<Product> arrSystem;
    static ListView lvData;
    View mView;
    Button btnAdd;
    MySQLite sqLite;

    @Override
    public void onResume() {
        super.onResume();
        arrSystem.clear();
        arrSystem.addAll(sqLite.getAllProduct());
        adapter.notifyDataSetChanged();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        //arrSystem = new ArrayList<Product>();

        mView = inflater.inflate(R.layout.fragment_product, container, false);
        lvData = mView.findViewById(R.id.idLVProduct);

        btnAdd = mView.findViewById(R.id.id_btn_ADD);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplication(), AddProduct.class);
                startActivity(intent);
            }
        });
        /*arrSystem.add(new Product("CF3009", "Coffee Joy", "20000", "VND"));
        arrSystem.add(new Product("CF1999", "Coffee Moka", "50000", "VND"));
        arrSystem.add(new Product("CF0300", "Coffee Latte", "55000", "VND"));
        arrSystem.add(new Product("CF0031", "Coffee Cherry", "83000", "VND"));
        arrSystem.add(new Product("CF0199", "Coffee Arabica", "91000", "VND"));
        adapter = new CustomAdapter(getContext(), R.layout.detail_lv, arrSystem);
        lvData.setAdapter(adapter);
*/
        sqLite = new MySQLite(getContext());
        arrSystem= sqLite.getAllProduct();
        if(arrSystem.isEmpty())
        {
            sqLite.addProduct("Coffee Joy", "20000", "CF3009", "VND");
            sqLite.addProduct("Coffee Moka", "50000", "CF1999", "VND");
            sqLite.addProduct("Coffee Latte", "55000", "CF0300", "VND");
            sqLite.addProduct("Coffee Cherry", "83000", "CF0031", "VND");
            sqLite.addProduct("Coffee Arabica", "91000", "CF0199","VND");
            arrSystem.addAll(sqLite.getAllProduct());
        }

        adapter = new CustomAdapter(getContext(), R.layout.detail_lv, arrSystem);
        lvData.setAdapter(adapter);
        return mView;
    }

}