package com.example.user.finaltest;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ProAdapter extends RecyclerView.Adapter<ProAdapter.ViewHolder> {
    List<ProductModel> models;
    int mResource;
    Context mContext;

    public ProAdapter(List<ProductModel> models, int mResource, Context mContext) {
        this.models = models;
        this.mResource = mResource;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ProAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(mContext).inflate(mResource,viewGroup,false);
        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull ProAdapter.ViewHolder viewHolder, final int i) {
        final ProductModel model = models.get(i);
        viewHolder.txtName.setText(model.getProduct_name());
        viewHolder.txtId.setText(String.valueOf(model.getId()));
        viewHolder.txtProducer.setText(model.getProducer());
        viewHolder.txtDes.setText(model.getDescription());
        viewHolder.txtKey.setText(model.getKey());
        viewHolder.txtPrice.setText(String.valueOf(model.getPrice()));
        viewHolder.btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowMain.myRef.child(model.getKey()).removeValue();
                ShowMain.listpro = new ArrayList<ProductModel>();
                ShowMain.listpro.remove(model);
                notifyDataSetChanged();
            }
        });
        viewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent intent = new Intent(mContext, Detail_item.class);
                // intent.putExtra("Detail", model);
                //intent.putExtra("Pos", i);
                //mContext.startActivity(intent);
            }
        });
        viewHolder.btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, Update.class);
                intent.putExtra("DataUp",model);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtPrice;
        private TextView txtName;
        private TextView txtKey;
        private TextView txtDes;
        private TextView txtProducer;
        private TextView txtId;
        private LinearLayout linearLayout;
        private Button btnDel;
        private Button btnUpdate;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.linearLayout = itemView.findViewById(R.id.id_layout);
            this.txtName = itemView.findViewById(R.id.id_txt_detail_name);
            this.txtDes = itemView.findViewById(R.id.id_txt_detail_desc);
            this.txtPrice = itemView.findViewById(R.id.id_txt_detail_price);
            this.txtProducer = itemView.findViewById(R.id.id_txt_detail_producder);
            this.txtId = itemView.findViewById(R.id.id_txt_detail_id);
            this.txtKey = itemView.findViewById(R.id.id_key_detail);
            this.btnDel = itemView.findViewById(R.id.id_btn_Del);
            this.btnUpdate = itemView.findViewById(R.id.id_btn_Update);
        }
    }
}

