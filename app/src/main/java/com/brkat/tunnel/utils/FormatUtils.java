package com.brkat.tunnel.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * FormatUtils - أداة تنسيق البيانات
 */
public class FormatUtils {

    /**
     * تنسيق البيانات من البايتات
     */
    public static String formatBytes(long bytes) {
        if (bytes <= 0) return "0 B";
        final String[] units = new String[]{"B", "KB", "MB", "GB", "TB"};
        int digitGroups = (int) (Math.log10(bytes) / Math.log10(1024));
        return String.format("%.2f %s", bytes / Math.pow(1024, digitGroups), units[digitGroups]);
    }

    /**
     * تنسيق السرعة من بايت/ثانية إلى صيغة مناسبة
     */
    public static String formatSpeed(long bytesPerSecond) {
        long bitsPerSecond = bytesPerSecond * 8;
        if (bitsPerSecond < 1000) {
            return bitsPerSecond + " bps";
        } else if (bitsPerSecond < 1000000) {
            return String.format("%.2f Kbps", bitsPerSecond / 1000.0);
        } else if (bitsPerSecond < 1000000000) {
            return String.format("%.2f Mbps", bitsPerSecond / 1000000.0);
        } else {
            return String.format("%.2f Gbps", bitsPerSecond / 1000000000.0);
        }
    }

    /**
     * تنسيق الوقت بالملي ثانية
     */
    public static String formatTime(long milliseconds) {
        long seconds = milliseconds / 1000;
        long hours = seconds / 3600;
        long minutes = (seconds % 3600) / 60;
        long secs = seconds % 60;

        if (hours > 0) {
            return String.format("%02d:%02d:%02d", hours, minutes, secs);
        } else {
            return String.format("%02d:%02d", minutes, secs);
        }
    }

    /**
     * تنسيق التاريخ والوقت
     */
    public static String formatDateTime(long timestamp) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        return sdf.format(new Date(timestamp));
    }

    /**
     * تنسيق الوقت فقط
     */
    public static String formatTimeOnly(long timestamp) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
        return sdf.format(new Date(timestamp));
    }

    /**
     * تنسيق التاريخ فقط
     */
    public static String formatDateOnly(long timestamp) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        return sdf.format(new Date(timestamp));
    }
}