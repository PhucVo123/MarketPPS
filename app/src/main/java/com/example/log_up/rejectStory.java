package com.example.log_up;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class rejectStory extends Fragment {
    private RecyclerView recyclerView;
    private ItemRejectedManageAdapter rejectedManageAdapter;
    private ArrayList<ItemManageConfirm> listItem;
    private LinearLayoutManager layoutManager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reject_story, container, false);
        recyclerView = view.findViewById(R.id.recycleViewReject);
        listItem = initData();
        rejectedManageAdapter = new ItemRejectedManageAdapter(getContext(), listItem);
        layoutManager = new LinearLayoutManager(getContext());
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setAdapter(rejectedManageAdapter);
        recyclerView.setLayoutManager(layoutManager);

        return view;
    }
    private ArrayList<ItemManageConfirm> initData()
    {
        ArrayList<ItemManageConfirm> listback = new ArrayList<>();
        String[] name = {"Giay","Dep"};
        String[] price = {"750.000d","600.000d"};
        int[] img = {R.drawable.thankyoufortrust, R.drawable.welcomeback};
        for(int i =0; i<name.length; i++)
        {
            ItemManageConfirm item = new ItemManageConfirm();
            item.setName(name[i]);
            item.setPrice(price[i]);
            item.setImg(img[i]);
            listback.add(item);
        }
        return listback;
    }
}