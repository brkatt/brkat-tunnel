package com.brkat.tunnel.ui.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.brkat.tunnel.databinding.ActivitySettingsBinding;

/**
 * SettingsActivity - نشاط الإعدادات
 * يحتوي على خيارات إعدادات التطبيق
 */
public class SettingsActivity extends AppCompatActivity {

    private ActivitySettingsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySettingsBinding.inflate(getLayoutInflater());
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