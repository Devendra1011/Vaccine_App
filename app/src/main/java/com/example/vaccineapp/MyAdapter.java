package com.example.vaccineapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    // 4- Handling the click events

    public static ItemClickListener clickListener;

    // 1- Data Source
    private VaccineModel[] listData;

    public MyAdapter(VaccineModel[] listData) {
        this.listData = listData;
    }

    public void setClickListener(ItemClickListener clickListener) {
        this.clickListener = clickListener;
    }

    // 2 - ViewHolder Class:
    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


        public ImageView ivVaccineImg;
        public TextView tvVaccineName;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            this.ivVaccineImg = itemView.findViewById(R.id.rv_iv_item);
            this.tvVaccineName = itemView.findViewById(R.id.rv_tv_vaccine);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {

            if (clickListener != null){
                clickListener.onClick(v, getAdapterPosition());

            }

        }
    }

    // 3- Implementing the methods

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View listItem = inflater.inflate(R.layout.recyclerview_item_layout,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(listItem);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final VaccineModel myListData = listData[position];
        holder.tvVaccineName.setText(listData[position].getVaccineName());
        holder.ivVaccineImg.setImageResource(listData[position].getVaccineImg());


    }

    @Override
    public int getItemCount() {
         return listData.length;
    }

}
