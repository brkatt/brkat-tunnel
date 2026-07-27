package com.brkat.tunnel.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.brkat.tunnel.databinding.FragmentHomeBinding;

/**
 * HomeFragment - شاشة الرئيسية
 * تعرض حالة الاتصال وزر الاتصال الرئيسي
 */
public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
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