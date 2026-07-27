package com.brkat.tunnel.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * ConnectionLog - نموذج سجل الاتصال
 * يسجل جميع أحداث الاتصال والأخطاء والمعلومات
 */
@Entity(tableName = "connection_logs")
public class ConnectionLog {

    @PrimaryKey(autoGenerate = true)
    public long id;

    public enum LogType {
        CONNECTION_STARTED("بدء الاتصال"),
        CONNECTION_SUCCESSFUL("اتصال ناجح"),
        CONNECTION_FAILED("فشل الاتصال"),
        CONNECTION_CLOSED("إغلاق الاتصال"),
        RECONNECTION_ATTEMPT("محاولة إعادة الاتصال"),
        ERROR("خطأ"),
        WARNING("تحذير"),
        INFO("معلومة"),
        NETWORK_CHANGED("تغير الشبكة"),
        PACKET_LOSS_DETECTED("فقدان الحزم"),
        SPEED_TEST_RESULT("نتيجة اختبار السرعة");

        public final String displayName;

        LogType(String displayName) {
            this.displayName = displayName;
        }
    }

    public long serverId;
    public LogType type;
    public String message;
    public String errorDetails;
    public long timestamp;
    public String stackTrace;

    public ConnectionLog() {
        this.timestamp = System.currentTimeMillis();
    }

    public ConnectionLog(long serverId, LogType type, String message) {
        this.serverId = serverId;
        this.type = type;
        this.message = message;
        this.timestamp = System.currentTimeMillis();
    }

    public String getFormattedTime() {
        return new SimpleDateFormat("HH:mm:ss", Locale.getDefault())
                .format(new Date(timestamp));
    }

    public String getFormattedDateTime() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
                .format(new Date(timestamp));
    }

    public String getTypeString() {
        return type != null ? type.displayName : "غير معروف";
    }
}