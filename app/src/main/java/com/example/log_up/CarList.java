package com.example.log_up;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class CarList extends AppCompatActivity {
    private RecyclerView rcv_Car;
    private AdapterCar adapter;
    private ArrayList<ProductObject> items;
    ArrayList<ProductObject> arrayList = new ArrayList<>();
    private DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_list);

        rcv_Car = findViewById(R.id.rcv_car);
        adapter = new AdapterCar(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcv_Car.setLayoutManager(linearLayoutManager);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        rcv_Car.addItemDecoration(itemDecoration);
        items= new ArrayList<>();
        adapter.setData(items);
        rcv_Car.setAdapter(adapter);
        getItems();

    }
    private void getItems() {
        ArrayList<ProductObject> productList = new ArrayList<>();

        databaseReference = FirebaseDatabase.getInstance().getReference("product");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren())
                {
                    if(dataSnapshot.getValue(ProductObject.class).getVerify().equals("1") && dataSnapshot.getValue(ProductObject.class).getDanhmucSanPham().equals("Xe cộ"))
                    {
                        ProductObject productObject = dataSnapshot.getValue(ProductObject.class);
                        items.add(productObject);
                    }

                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}
