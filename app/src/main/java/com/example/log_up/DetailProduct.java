package com.example.log_up;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class DetailProduct extends AppCompatActivity {
    private ViewPager viewPager;
    private CircleIndicator circleIndicator;
    private TextView  tvNameDetailProduct, tvPriceDetailProduct, tvDiachiDetailProduct, chitietProduct, tvLienHe;
    private PhotoSliderDetailProductAdapter photoAdapter;
    private List<PhotoSliderDetailProduct> list;
    private Button btnChat, btnCall;
    private ProductObject product;
    private Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_product);
        Intent intent = getIntent();
        bundle = intent.getExtras();
        product = (ProductObject) bundle.get("object_item");
        viewPager = findViewById(R.id.imageDetailProduct);
        circleIndicator = findViewById(R.id.circleIndicatorDetailProduct);
        tvNameDetailProduct = findViewById(R.id.tv_nameDetailProduct);
        tvPriceDetailProduct = findViewById(R.id.tv_priceDetailProduct);
        tvDiachiDetailProduct = findViewById(R.id.tv_diachiDetailProduct);
        chitietProduct = findViewById(R.id.chitietProduct);
        btnChat = findViewById(R.id.btnChat);
        btnCall = findViewById(R.id.btnCall);
        tvLienHe = findViewById(R.id.lienhe);
        list = getListPhoto();
        photoAdapter = new PhotoSliderDetailProductAdapter(DetailProduct.this, getListPhoto());
        viewPager.setAdapter(photoAdapter);
        circleIndicator.setViewPager(viewPager);
        photoAdapter.registerDataSetObserver(circleIndicator.getDataSetObserver());
        getData();



    }
    private List<PhotoSliderDetailProduct> getListPhoto()
    {
        List<PhotoSliderDetailProduct> list = new ArrayList<>();

        return list;
    }
    private void getData()
    {
        if(bundle == null)
        {
            return;
        }
        tvNameDetailProduct.setText(product.getTenSanPham());
        tvPriceDetailProduct.setText(product.getGiaSanPham());
        tvDiachiDetailProduct.setText(product.getDiachiSanPham());
        chitietProduct.setText(product.getMotaSanPham());
        tvLienHe.setText("Liên hệ: "+product.getSodienthoaiUser().replace("+84",""));
        btnChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent transferMessage = new Intent(DetailProduct.this, MessageActivity.class);
                transferMessage.putExtra("idPhoneUser", product.getSodienthoaiUser());
                startActivity(transferMessage);
            }
        });

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                product.getSodienthoaiUser().replace("+84","");
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:"+ product.getSodienthoaiUser().replace("+84","")));//change the number
                startActivity(callIntent);
            }
        });
    }

}