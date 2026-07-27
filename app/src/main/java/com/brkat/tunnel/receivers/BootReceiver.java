package com.brkat.tunnel.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.brkat.tunnel.utils.LogUtils;
import com.brkat.tunnel.utils.PreferenceManager;

/**
 * BootReceiver - مستقبل حدث بدء التشغيل
 * يقوم بتشغيل التطبيق تلقائياً عند بدء الجهاز
 */
public class BootReceiver extends BroadcastReceiver {

    private static final String TAG = "BootReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        LogUtils.d(TAG, "Boot completed received");

        if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {
            PreferenceManager prefManager = PreferenceManager.getInstance(context);
            if (prefManager.isAutoConnect()) {
                // تشغيل خدمة VPN تلقائياً
                Intent vpnIntent = new Intent(context, com.brkat.tunnel.service.VpnService.class);
                context.startService(vpnIntent);
                LogUtils.d(TAG, "Auto-connect enabled, starting VPN service");
            }
        }
    }
}