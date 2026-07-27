package com.brkat.tunnel.utils;

import android.content.Context;
import androidx.datastore.preferences.Preferences;
import androidx.datastore.preferences.PreferencesDataStore;

/**
 * PreferenceManager - إدارة الإعدادات والبيانات المحفوظة
 * يستخدم DataStore للتعامل مع البيانات بشكل آمن وفعال
 */
public class PreferenceManager {

    private static final String PREFS_NAME = "brkat_preferences";
    private static final String KEY_AUTO_CONNECT = "auto_connect";
    private static final String KEY_AUTO_RECONNECT = "auto_reconnect";
    private static final String KEY_DARK_MODE = "dark_mode";
    private static final String KEY_KEEP_ALIVE = "keep_alive";
    private static final String KEY_SELECTED_SERVER_ID = "selected_server_id";
    private static final String KEY_NOTIFICATION_ENABLED = "notification_enabled";
    private static final String KEY_WAKE_LOCK = "wake_lock";
    private static final String KEY_SYSTEM_PROXY = "system_proxy";
    private static final String KEY_LAST_CONNECTED_TIME = "last_connected_time";

    private static PreferenceManager instance;
    private final android.content.SharedPreferences preferences;

    private PreferenceManager(Context context) {
        preferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    public static PreferenceManager getInstance(Context context) {
        if (instance == null) {
            synchronized (PreferenceManager.class) {
                if (instance == null) {
                    instance = new PreferenceManager(context);
                }
            }
        }
        return instance;
    }

    // Auto Connect
    public boolean isAutoConnect() {
        return preferences.getBoolean(KEY_AUTO_CONNECT, false);
    }

    public void setAutoConnect(boolean enabled) {
        preferences.edit().putBoolean(KEY_AUTO_CONNECT, enabled).apply();
    }

    // Auto Reconnect
    public boolean isAutoReconnect() {
        return preferences.getBoolean(KEY_AUTO_RECONNECT, true);
    }

    public void setAutoReconnect(boolean enabled) {
        preferences.edit().putBoolean(KEY_AUTO_RECONNECT, enabled).apply();
    }

    // Dark Mode
    public int getDarkMode() {
        return preferences.getInt(KEY_DARK_MODE, 0); // 0: System, 1: Dark, 2: Light
    }

    public void setDarkMode(int mode) {
        preferences.edit().putInt(KEY_DARK_MODE, mode).apply();
    }

    // Keep Alive
    public boolean isKeepAlive() {
        return preferences.getBoolean(KEY_KEEP_ALIVE, true);
    }

    public void setKeepAlive(boolean enabled) {
        preferences.edit().putBoolean(KEY_KEEP_ALIVE, enabled).apply();
    }

    // Selected Server ID
    public long getSelectedServerId() {
        return preferences.getLong(KEY_SELECTED_SERVER_ID, -1);
    }

    public void setSelectedServerId(long serverId) {
        preferences.edit().putLong(KEY_SELECTED_SERVER_ID, serverId).apply();
    }

    // Notification
    public boolean isNotificationEnabled() {
        return preferences.getBoolean(KEY_NOTIFICATION_ENABLED, true);
    }

    public void setNotificationEnabled(boolean enabled) {
        preferences.edit().putBoolean(KEY_NOTIFICATION_ENABLED, enabled).apply();
    }

    // Wake Lock
    public boolean isWakeLockEnabled() {
        return preferences.getBoolean(KEY_WAKE_LOCK, false);
    }

    public void setWakeLockEnabled(boolean enabled) {
        preferences.edit().putBoolean(KEY_WAKE_LOCK, enabled).apply();
    }

    // System Proxy
    public boolean isSystemProxyEnabled() {
        return preferences.getBoolean(KEY_SYSTEM_PROXY, true);
    }

    public void setSystemProxyEnabled(boolean enabled) {
        preferences.edit().putBoolean(KEY_SYSTEM_PROXY, enabled).apply();
    }

    // Last Connected Time
    public long getLastConnectedTime() {
        return preferences.getLong(KEY_LAST_CONNECTED_TIME, 0);
    }

    public void setLastConnectedTime(long time) {
        preferences.edit().putLong(KEY_LAST_CONNECTED_TIME, time).apply();
    }

    // Clear all preferences
    public void clearAll() {
        preferences.edit().clear().apply();
    }
}