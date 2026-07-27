package com.brkat.tunnel.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.brkat.tunnel.models.ConnectionLog;
import com.brkat.tunnel.models.ConnectionStats;
import com.brkat.tunnel.models.Server;

/**
 * BrkatDatabase - قاعدة البيانات الرئيسية
 * تحتوي على جميع الجداول وتوفر نقطة الوصول الوحيدة للبيانات
 */
@Database(
        entities = {Server.class, ConnectionStats.class, ConnectionLog.class},
        version = 1,
        exportSchema = false
)
public abstract class BrkatDatabase extends RoomDatabase {

    private static volatile BrkatDatabase instance;

    public abstract ServerDao serverDao();
    public abstract ConnectionStatsDao connectionStatsDao();
    public abstract ConnectionLogDao connectionLogDao();

    /**
     * الحصول على نسخة واحدة من قاعدة البيانات (Singleton)
     */
    public static BrkatDatabase getInstance(Context context) {
        if (instance == null) {
            synchronized (BrkatDatabase.class) {
                if (instance == null) {
                    instance = Room.databaseBuilder(
                            context.getApplicationContext(),
                            BrkatDatabase.class,
                            "brkat_database"
                    )
                            .fallbackToDestructiveMigration()
                            .enableMultiInstanceInvalidation()
                            .build();
                }
            }
        }
        return instance;
    }

    /**
     * إغلاق قاعدة البيانات
     */
    public static void closeDatabase() {
        if (instance != null) {
            instance.close();
            instance = null;
        }
    }
}