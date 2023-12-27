package com.example.log_up;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.text.HtmlCompat;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView navigationView;
    private ViewPager viewPager;
    private SharedPreferences sharedPreferences;
    static String getPhone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent giveData = getIntent();
        String getPass = giveData.getStringExtra("password");
        getPhone = giveData.getStringExtra("phone");
        sharedPreferences = getSharedPreferences("dataLogin", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("phone", null);
        editor.putString("password", null);

//        String getPassword = giveData.getStringExtra("password");
        if(sharedPreferences.getString("phone","") == null || sharedPreferences.getString("password","") == null)
        {
            Intent intent = new Intent(MainActivity.this, LogIn.class);
            startActivity(intent);
        }
        navigationView = findViewById(R.id.nav_bottom);
        viewPager = findViewById(R.id.view_pager);
        setUpViewPager();
        navigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.action_home:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.action_manage:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.action_load:
                        viewPager.setCurrentItem(2);
                        break;
                    case R.id.action_cart:
                        viewPager.setCurrentItem(3);
                        break;
                    case R.id.action_more:
                        viewPager.setCurrentItem(4);
                        break;
                }
                return true;
            }
        });
    }
    private void setUpViewPager()
    {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
         viewPager.setAdapter(viewPagerAdapter);
         viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
             @Override
             public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

             }

             @Override
             public void onPageSelected(int position) {
                 switch (position)
                 {
                     case 0:
                         navigationView.getMenu().findItem(R.id.action_home).setChecked(true);
                         break;
                     case 1:
                         navigationView.getMenu().findItem(R.id.action_manage).setChecked(true);
                         break;
                     case 2:
                         navigationView.getMenu().findItem(R.id.action_load).setChecked(true);
                         break;
                     case 3:
                         navigationView.getMenu().findItem(R.id.action_cart).setChecked(true);
                         break;
                     case 4:
                         navigationView.getMenu().findItem(R.id.action_more).setChecked(true);
                         break;
                 }

             }

             @Override
             public void onPageScrollStateChanged(int state) {

             }
         });
    }
    public String getData()
    {
        return getPhone;
    }
    public boolean checkPhone(String phone)
    {
        if(phone.equals(getPhone))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

}