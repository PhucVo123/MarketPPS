package com.example.log_up;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterSport extends RecyclerView.Adapter<AdapterSport.ItemViewHolder>{
    Context context;
    ArrayList<ProductObject> mList;
    boolean check =false;

    public AdapterSport(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<ProductObject> list) {
        this.mList = list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_sport, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        ProductObject itemSport = mList.get(position);
        if (itemSport == null) {
            return;
        }
        holder.textTitle.setText(itemSport.getDanhmucSanPham());
        holder.textPrice.setText(itemSport.getGiaSanPham());
        holder.textDes.setText(itemSport.getMotaSanPham());
        holder.icon_heart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setSelected(!v.isSelected());
                if (v.isSelected()){
                    holder.icon_heart.setImageResource(R.drawable.heart_checked);
                }
                else {
                    holder.icon_heart.setImageResource(R.drawable.heart);
                }
            }
        });
        holder.setIsRecyclable(true);

    }

    @Override
    public int getItemCount() {
        if (mList.size()==0)
        {
            return 0;
        }
        return mList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        ImageView imgSport;
        TextView textTitle , textDes, textPrice;
        ImageView icon_heart;
        public ItemViewHolder(@NonNull View itemView) {

            super(itemView);
            this.setIsRecyclable(false);
            imgSport = itemView.findViewById(R.id.img_itemSport);
            textTitle = itemView.findViewById(R.id.tv_item_sport);
            textDes = itemView.findViewById(R.id.tv_describe_sport);
            textPrice = itemView.findViewById(R.id.tv_price_sport);
            icon_heart = itemView.findViewById(R.id.icon_heart);

        }
    }
}
