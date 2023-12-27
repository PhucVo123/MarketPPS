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

public class ItemConfirmManageAdapter extends RecyclerView.Adapter<ItemConfirmManageAdapter.ViewHolder> {
    private Context context;
    private List<ItemManageConfirm> listItem;

    public ItemConfirmManageAdapter(Context context, List<ItemManageConfirm> listItem)
    {
        this.context = context;
        this.listItem = listItem;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.item_manage_story, parent, false);


        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ItemManageConfirm item = listItem.get(position);
        holder.name.setText(item.getName());
        holder.price.setText(item.getPrice());
        holder.image.setImageResource(item.getImg());
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
        private TextView name, price;
        private ImageView image, imageBtn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.nameStoryConfirmed);
            price = itemView.findViewById(R.id.priceStoryConfirmed);
            image = itemView.findViewById(R.id.imageConfirmed);
            imageBtn = itemView.findViewById(R.id.btnMenu);
        }
    }
}
