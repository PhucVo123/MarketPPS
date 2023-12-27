package com.example.log_up;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SportList extends AppCompatActivity {
    private RecyclerView rcv_sport;
    AdapterSport adapter;
    ArrayList<ProductObject> items;
    ArrayList<ProductObject> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sport_list);
        rcv_sport = findViewById(R.id.rcv_sport);
        adapter = new AdapterSport(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcv_sport.setLayoutManager(linearLayoutManager);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        rcv_sport.addItemDecoration(itemDecoration);
        items=getItems();
        adapter.setData(items);
        rcv_sport.setAdapter(adapter);
    }
    public ArrayList<ProductObject> getItems(){
        arrayList.add(new ProductObject(1,"Giay The Thao","Giay","1800","The Thao","Con` Hang","","",""));
       return  arrayList;
    }
}