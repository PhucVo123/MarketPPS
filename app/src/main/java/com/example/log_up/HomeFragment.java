package com.example.log_up;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;


public class HomeFragment extends Fragment {
    private ViewPager viewPager;
    private CircleIndicator circleIndicator;
    private PhotoSliderHomeAdapter photoAdapter;
    private Timer timer;
    private List<PhotoHomeSlider> list;
    private ImageView imgXeco;
    private LinearLayout sport;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        viewPager = view.findViewById(R.id.viewPagerHome);
        imgXeco = view.findViewById(R.id.imgXeco);
        circleIndicator = view.findViewById(R.id.circleIndicator);
        list = getListPhoto();
        photoAdapter = new PhotoSliderHomeAdapter(getContext(), getListPhoto());
        autoSlidePhoto();
        viewPager.setAdapter(photoAdapter);
        circleIndicator.setViewPager(viewPager);
        photoAdapter.registerDataSetObserver(circleIndicator.getDataSetObserver());
        imgXeco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), CarList.class);
                startActivity(intent);
            }
        });

        sport = view.findViewById(R.id.Sport);
        sport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),SportList.class);
                startActivity(intent);
            }
        });

        return view;
    }
    private List<PhotoHomeSlider> getListPhoto()
    {
        List<PhotoHomeSlider> list = new ArrayList<>();
        list.add(new PhotoHomeSlider(R.drawable.thankyoufortrust));
        list.add(new PhotoHomeSlider(R.drawable.welcomeback));
        list.add(new PhotoHomeSlider(R.drawable.trust));
        return list;
    }
    private void autoSlidePhoto()
    {
        if(list == null || list.isEmpty() || viewPager == null)
        {
            return;
        }
        if(timer == null)
        {
            timer = new Timer();
        }
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        int currentItem = viewPager.getCurrentItem();
                        int totalItem = list.size() - 1;
                        if(currentItem < totalItem)
                        {
                            currentItem++;
                            viewPager.setCurrentItem(currentItem);
                        }
                        else
                        {
                            viewPager.setCurrentItem(0);
                        }
                    }
                });
            }
        }, 500, 3000);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(timer != null)
        {
            timer.cancel();
            timer = null;
        }
    }
}