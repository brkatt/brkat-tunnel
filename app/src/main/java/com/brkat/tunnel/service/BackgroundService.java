package com.brkat.tunnel.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

import com.brkat.tunnel.utils.LogUtils;

/**
 * BackgroundService - خدمة الخلفية الرئيسية
 * تقوم بتشغيل العمليات في الخلفية
 */
public class BackgroundService extends Service {

    private static final String TAG = "BackgroundService";

    @Override
    public void onCreate() {
        super.onCreate();
        LogUtils.d(TAG, "BackgroundService created");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        LogUtils.d(TAG, "BackgroundService started");
        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtils.d(TAG, "BackgroundService destroyed");
    }
}