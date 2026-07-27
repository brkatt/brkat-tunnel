package com.brkat.tunnel.ui.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.brkat.tunnel.databinding.ActivityAboutBinding;

/**
 * AboutActivity - نشاط حول التطبيق
 * يعرض معلومات عن التطبيق والمطورين
 */
public class AboutActivity extends AppCompatActivity {

    private ActivityAboutBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAboutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setupUI();
    }

    /**
     * إعداد واجهة المستخدم
     */
    private void setupUI() {
        // سيتم إضافة تفاصيل إعداد الواجهة
    }
}