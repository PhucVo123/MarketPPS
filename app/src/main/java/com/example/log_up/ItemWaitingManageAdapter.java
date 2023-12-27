package com.example.log_up;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemWaitingManageAdapter extends RecyclerView.Adapter<ItemWaitingManageAdapter.ViewHolder> {

    private Context context;
    private List<ProductObject> listItem;

    public ItemWaitingManageAdapter(Context context, List<ProductObject> listItem)
    {
        this.context = context;
        this.listItem = listItem;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.item_manage_wait, parent, false);


        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProductObject item = listItem.get(position);
        holder.name.setText(item.getTenSanPham());
        holder.price.setText(item.getGiaSanPham());
//        holder.image.setImageResource(item.getImageUrl());
        holder.tittle.setText(item.getDanhmucSanPham());
        holder.imageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(view.getContext(), holder.imageBtn);
                popupMenu.inflate(R.menu.option_menu_item_confirm);
                popupMenu.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name, price, tittle;
        private ImageView image, imageBtn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.nameStoryWait);
            price = itemView.findViewById(R.id.priceStoryWait);
            image = itemView.findViewById(R.id.imageWait);
            imageBtn = itemView.findViewById(R.id.btnMenuWait);
            tittle = itemView.findViewById(R.id.tittleStoryWait);

        }
    }
}
