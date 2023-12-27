package com.example.log_up;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class showStory extends Fragment {
    private ItemConfirmManageAdapter itemAdapter;
    private ArrayList<ItemManageConfirm> listConfirm;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private TextView textEmpty;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_show_story, container, false);
        recyclerView = view.findViewById(R.id.recycleViewConfirm);
        textEmpty = view.findViewById(R.id.textEmpty);
        listConfirm = new ArrayList<>();
        itemAdapter = new ItemConfirmManageAdapter(getContext(),listConfirm);
        linearLayoutManager = new LinearLayoutManager(getContext());
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), linearLayoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setAdapter(itemAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
        if(listConfirm.size() == 0)
        {

            textEmpty.setVisibility(View.VISIBLE);
        }
        else
        {
            textEmpty.setVisibility(View.INVISIBLE);
        }
        return view;
    }
    private ArrayList<ItemManageConfirm> checkData()
    {
        ArrayList<ItemManageConfirm> list = new ArrayList<>();
        String[] name = {"Giay","Dep"};
        String[] price = {"750.000d","600.000d"};
        int[] img = {R.drawable.thankyoufortrust, R.drawable.welcomeback};
        for(int i =0; i<name.length; i++)
        {
            ItemManageConfirm item = new ItemManageConfirm();
            item.setName(name[i]);
            item.setPrice(price[i]);
            item.setImg(img[i]);
            list.add(item);
        }
        return list;
    }
}