package com.brkat.tunnel.ui.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.brkat.tunnel.ui.fragments.HomeFragment;
import com.brkat.tunnel.ui.fragments.ServersFragment;
import com.brkat.tunnel.ui.fragments.LogsFragment;
import com.brkat.tunnel.ui.fragments.ToolsFragment;
import com.brkat.tunnel.ui.fragments.SettingsFragment;

/**
 * MainPagerAdapter - محول الصفحات الرئيسية
 */
public class MainPagerAdapter extends FragmentStateAdapter {

    private static final int NUM_PAGES = 5;

    public MainPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new HomeFragment();
            case 1:
                return new ServersFragment();
            case 2:
                return new LogsFragment();
            case 3:
                return new ToolsFragment();
            case 4:
                return new SettingsFragment();
            default:
                return new HomeFragment();
        }
    }

    @Override
    public int getItemCount() {
        return NUM_PAGES;
    }
}