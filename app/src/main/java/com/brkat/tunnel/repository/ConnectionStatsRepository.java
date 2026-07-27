package com.brkat.tunnel.repository;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.brkat.tunnel.database.BrkatDatabase;
import com.brkat.tunnel.database.ConnectionStatsDao;
import com.brkat.tunnel.models.ConnectionStats;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * ConnectionStatsRepository - مستودع البيانات لإحصائيات الاتصال
 * يوفر طريقة موحدة للوصول إلى بيانات الإحصائيات
 */
public class ConnectionStatsRepository {

    private ConnectionStatsDao statsDao;
    private Executor executor = Executors.newSingleThreadExecutor();

    public ConnectionStatsRepository(Context context) {
        BrkatDatabase database = BrkatDatabase.getInstance(context);
        this.statsDao = database.connectionStatsDao();
    }

    /**
     * إدراج إحصائيات جديدة
     */
    public void insertStats(ConnectionStats stats) {
        executor.execute(() -> statsDao.insertStats(stats));
    }

    /**
     * تحديث الإحصائيات
     */
    public void updateStats(ConnectionStats stats) {
        executor.execute(() -> statsDao.updateStats(stats));
    }

    /**
     * حذف الإحصائيات
     */
    public void deleteStats(ConnectionStats stats) {
        executor.execute(() -> statsDao.deleteStats(stats));
    }

    /**
     * الحصول على الإحصائيات بالمعرّف
     */
    public LiveData<ConnectionStats> getStatsById(long statsId) {
        return statsDao.getStatsById(statsId);
    }

    /**
     * الحصول على آخر إحصائيات للسيرفر
     */
    public LiveData<ConnectionStats> getLatestStatsForServer(long serverId) {
        return statsDao.getLatestStatsForServer(serverId);
    }

    /**
     * الحصول على إحصائيات آخر ساعة
     */
    public LiveData<List<ConnectionStats>> getStatsLastHour(long serverId) {
        return statsDao.getStatsLastHour(serverId);
    }

    /**
     * الحصول على إحصائيات آخر يوم
     */
    public LiveData<List<ConnectionStats>> getStatsLastDay(long serverId) {
        return statsDao.getStatsLastDay(serverId);
    }

    /**
     * حذف الإحصائيات القديمة
     */
    public void deleteOldStats() {
        executor.execute(statsDao::deleteOldStats);
    }

    /**
     * حذف إحصائيات السيرفر
     */
    public void deleteStatsForServer(long serverId) {
        executor.execute(() -> statsDao.deleteStatsForServer(serverId));
    }
}