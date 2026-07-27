package com.brkat.tunnel.ui.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.brkat.tunnel.databinding.ActivityServerDetailsBinding;

/**
 * ServerDetailsActivity - نشاط تفاصيل السيرفر
 * يحتوي على نموذج لإضافة أو تعديل السيرفر
 */
public class ServerDetailsActivity extends AppCompatActivity {

    private ActivityServerDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityServerDetailsBinding.inflate(getLayoutInflater());
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