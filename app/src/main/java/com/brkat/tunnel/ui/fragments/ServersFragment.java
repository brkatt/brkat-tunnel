package com.brkat.tunnel.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.brkat.tunnel.databinding.FragmentServersBinding;

/**
 * ServersFragment - شاشة السيرفرات
 * تعرض قائمة بجميع السيرفرات المضافة
 */
public class ServersFragment extends Fragment {

    private FragmentServersBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentServersBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupUI();
    }

    /**
     * إعداد واجهة المستخدم
     */
    private void setupUI() {
        // سيتم إضافة تفاصيل إعداد الواجهة
    }
}