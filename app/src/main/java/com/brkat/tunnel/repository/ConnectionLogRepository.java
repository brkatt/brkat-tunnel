package com.brkat.tunnel.repository;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.brkat.tunnel.database.BrkatDatabase;
import com.brkat.tunnel.database.ConnectionLogDao;
import com.brkat.tunnel.models.ConnectionLog;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * ConnectionLogRepository - مستودع البيانات لسجلات الاتصال
 * يوفر طريقة موحدة للوصول إلى بيانات السجلات
 */
public class ConnectionLogRepository {

    private ConnectionLogDao logDao;
    private Executor executor = Executors.newSingleThreadExecutor();

    public ConnectionLogRepository(Context context) {
        BrkatDatabase database = BrkatDatabase.getInstance(context);
        this.logDao = database.connectionLogDao();
    }

    /**
     * إدراج سجل جديد
     */
    public void insertLog(ConnectionLog log) {
        executor.execute(() -> logDao.insertLog(log));
    }

    /**
     * حذف السجل
     */
    public void deleteLog(ConnectionLog log) {
        executor.execute(() -> logDao.deleteLog(log));
    }

    /**
     * الحصول على سجلات السيرفر
     */
    public LiveData<List<ConnectionLog>> getLogsForServer(long serverId) {
        return logDao.getLogsForServer(serverId);
    }

    /**
     * الحصول على آخر السجلات
     */
    public LiveData<List<ConnectionLog>> getLatestLogs() {
        return logDao.getLatestLogs();
    }

    /**
     * الحصول على السجلات من آخر ساعة
     */
    public LiveData<List<ConnectionLog>> getLogsLastHour() {
        return logDao.getLogsLastHour();
    }

    /**
     * البحث في السجلات
     */
    public LiveData<List<ConnectionLog>> searchLogs(String query) {
        return logDao.searchLogs(query);
    }

    /**
     * حذف السجلات القديمة
     */
    public void deleteOldLogs() {
        executor.execute(logDao::deleteOldLogs);
    }

    /**
     * حذف جميع السجلات
     */
    public void deleteAllLogs() {
        executor.execute(logDao::deleteAllLogs);
    }

    /**
     * عدد السجلات
     */
    public LiveData<Integer> getLogsCount() {
        return logDao.getLogsCount();
    }
}