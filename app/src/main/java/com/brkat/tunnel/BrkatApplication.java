package com.brkat.tunnel;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

/**
 * BrkatApplication - تطبيق Brkat Tunnel الرئيسي
 * يقوم بتهيئة المكونات الأساسية والقنوات التنبيهية
 */
public class BrkatApplication extends Application {

    public static final String CHANNEL_ID_FOREGROUND = "brkat_foreground_service";
    public static final String CHANNEL_ID_NOTIFICATION = "brkat_notifications";

    @Override
    public void onCreate() {
        super.onCreate();
        initializeNotificationChannels();
    }

    /**
     * تهيئة قنوات التنبيهات للإصدارات الحديثة من Android
     */
    private void initializeNotificationChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            if (notificationManager != null) {
                NotificationChannel foregroundChannel = new NotificationChannel(
                        CHANNEL_ID_FOREGROUND,
                        getString(R.string.notification_channel_vpn),
                        NotificationManager.IMPORTANCE_LOW
                );
                foregroundChannel.setShowBadge(false);
                foregroundChannel.enableVibration(false);
                notificationManager.createNotificationChannel(foregroundChannel);

                NotificationChannel notificationChannel = new NotificationChannel(
                        CHANNEL_ID_NOTIFICATION,
                        getString(R.string.notification_channel_general),
                        NotificationManager.IMPORTANCE_DEFAULT
                );
                notificationManager.createNotificationChannel(notificationChannel);
            }
        }
    }
}