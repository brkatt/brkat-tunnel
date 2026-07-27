package com.brkat.tunnel.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;

import com.brkat.tunnel.utils.LogUtils;
import com.brkat.tunnel.utils.PreferenceManager;

/**
 * NetworkReceiver - مستقبل تغيرات الشبكة
 * يراقب تغيرات اتصال الشبكة
 */
public class NetworkReceiver extends BroadcastReceiver {

    private static final String TAG = "NetworkReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())) {
            LogUtils.d(TAG, "Network changed");

            PreferenceManager prefManager = PreferenceManager.getInstance(context);
            if (prefManager.isAutoReconnect()) {
                LogUtils.d(TAG, "Auto-reconnect enabled");
                // إعادة الاتصال تلقائياً
                Intent vpnIntent = new Intent(context, com.brkat.tunnel.service.VpnService.class);
                context.startService(vpnIntent);
            }
        }
    }
}