package com.brkat.tunnel.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

import com.brkat.tunnel.utils.LogUtils;

/**
 * VpnService - خدمة VPN الرئيسية
 * تقوم بإدارة اتصال VPN والعمليات المتعلقة به
 */
public class VpnService extends Service {

    private static final String TAG = "VpnService";

    @Override
    public void onCreate() {
        super.onCreate();
        LogUtils.d(TAG, "VpnService created");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        LogUtils.d(TAG, "VpnService started");
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
        LogUtils.d(TAG, "VpnService destroyed");
    }
}