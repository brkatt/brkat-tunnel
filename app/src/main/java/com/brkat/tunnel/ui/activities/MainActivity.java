package com.brkat.tunnel.ui.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.brkat.tunnel.R;
import com.brkat.tunnel.databinding.ActivityMainBinding;
import com.brkat.tunnel.ui.adapters.MainPagerAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

/**
 * MainActivity - النشاط الرئيسي للتطبيق
 * يحتوي على Bottom Navigation و ViewPager2
 */
public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private MainPagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setupViewPager();
        setupBottomNavigation();
    }

    /**
     * إعداد ViewPager2
     */
    private void setupViewPager() {
        pagerAdapter = new MainPagerAdapter(this);
        binding.viewPager.setAdapter(pagerAdapter);
        binding.viewPager.setUserInputEnabled(false); // تعطيل السحب
        binding.viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                binding.bottomNavigation.getMenu().getItem(position).setChecked(true);
            }
        });
    }

    /**
     * إعداد BottomNavigationView
     */
    private void setupBottomNavigation() {
        binding.bottomNavigation.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.nav_home) {
                binding.viewPager.setCurrentItem(0);
                return true;
            } else if (itemId == R.id.nav_servers) {
                binding.viewPager.setCurrentItem(1);
                return true;
            } else if (itemId == R.id.nav_logs) {
                binding.viewPager.setCurrentItem(2);
                return true;
            } else if (itemId == R.id.nav_tools) {
                binding.viewPager.setCurrentItem(3);
                return true;
            } else if (itemId == R.id.nav_settings) {
                binding.viewPager.setCurrentItem(4);
                return true;
            }
            return false;
        });
    }
}