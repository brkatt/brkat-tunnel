package com.brkat.tunnel.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * ConnectionStats - نموذج إحصائيات الاتصال
 * يتتبع بيانات الاتصال الحالية والتاريخية
 */
@Entity(tableName = "connection_stats")
public class ConnectionStats {

    @PrimaryKey(autoGenerate = true)
    public long id;

    public long serverId;
    public long uploadSpeed;      // بايت/ثانية
    public long downloadSpeed;    // بايت/ثانية
    public long totalUploaded;    // إجمالي المرفوع
    public long totalDownloaded;  // إجمالي المنزل
    public long connectionDuration; // مدة الاتصال بالملي ثانية
    public String userIp;
    public String userCountry;
    public double ping;
    public double packetLoss;
    public double latency;
    public long timestamp;

    public ConnectionStats() {
        this.timestamp = System.currentTimeMillis();
        this.uploadSpeed = 0;
        this.downloadSpeed = 0;
        this.totalUploaded = 0;
        this.totalDownloaded = 0;
        this.connectionDuration = 0;
        this.ping = 0;
        this.packetLoss = 0;
        this.latency = 0;
    }

    public double getUploadSpeedMbps() {
        return (uploadSpeed * 8) / 1_000_000.0;
    }

    public double getDownloadSpeedMbps() {
        return (downloadSpeed * 8) / 1_000_000.0;
    }

    public String getTotalUploadedFormatted() {
        return formatBytes(totalUploaded);
    }

    public String getTotalDownloadedFormatted() {
        return formatBytes(totalDownloaded);
    }

    private String formatBytes(long bytes) {
        if (bytes <= 0) return "0 B";
        final String[] units = new String[]{"B", "KB", "MB", "GB", "TB"};
        int digitGroups = (int) (Math.log10(bytes) / Math.log10(1024));
        return String.format("%.2f %s", bytes / Math.pow(1024, digitGroups), units[digitGroups]);
    }

    public String getConnectionDurationFormatted() {
        long seconds = connectionDuration / 1000;
        long hours = seconds / 3600;
        long minutes = (seconds % 3600) / 60;
        long secs = seconds % 60;

        if (hours > 0) {
            return String.format("%02d:%02d:%02d", hours, minutes, secs);
        } else {
            return String.format("%02d:%02d", minutes, secs);
        }
    }
}