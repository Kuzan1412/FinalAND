package com.example.user.midterm_adv;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class PhoneAdapter extends RecyclerView.Adapter<PhoneAdapter.ViewHolder> {
    List<Phone> models;
    int mResource;
    Context mContext;

    public PhoneAdapter(List<Phone> models, int mResource, Context mContext) {
        this.models = models;
        this.mResource = mResource;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public PhoneAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(mContext).inflate(mResource,viewGroup,false);
        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull PhoneAdapter.ViewHolder viewHolder, final int i) {
        final Phone model = models.get(i);
        viewHolder.txtName.setText(model.getProName());

        viewHolder.txtProducer.setText(model.getProDucer());
        viewHolder.txtDes.setText(model.getProDes());
        viewHolder.txtPrice.setText(String.valueOf(model.getProPrice()));
        viewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, Detail_item.class);
                intent.putExtra("Detail", model);
                intent.putExtra("Pos", i);
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
        private  TextView txtDes;
        private TextView txtProducer;
        private LinearLayout linearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.linearLayout = itemView.findViewById(R.id.id_LayoutPhone);
            this.txtName = itemView.findViewById(R.id.id_namepro);
            this.txtDes = itemView.findViewById(R.id.id_description);
            this.txtPrice = itemView.findViewById(R.id.id_price);
            this.txtProducer = itemView.findViewById(R.id.id_producer);
        }
    }
}
