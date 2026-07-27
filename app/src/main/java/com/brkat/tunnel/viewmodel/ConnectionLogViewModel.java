package com.brkat.tunnel.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.brkat.tunnel.models.ConnectionLog;
import com.brkat.tunnel.repository.ConnectionLogRepository;

import java.util.List;

/**
 * ConnectionLogViewModel - نموذج العرض لسجلات الاتصال
 * يدير بيانات السجلات ويوفرها للواجهات
 */
public class ConnectionLogViewModel extends AndroidViewModel {

    private ConnectionLogRepository repository;
    private LiveData<List<ConnectionLog>> latestLogs;

    public ConnectionLogViewModel(Application application) {
        super(application);
        repository = new ConnectionLogRepository(application);
        latestLogs = repository.getLatestLogs();
    }

    /**
     * الحصول على آخر السجلات
     */
    public LiveData<List<ConnectionLog>> getLatestLogs() {
        return latestLogs;
    }

    /**
     * الحصول على سجلات السيرفر
     */
    public LiveData<List<ConnectionLog>> getLogsForServer(long serverId) {
        return repository.getLogsForServer(serverId);
    }

    /**
     * البحث في السجلات
     */
    public LiveData<List<ConnectionLog>> searchLogs(String query) {
        return repository.searchLogs(query);
    }

    /**
     * إدراج سجل
     */
    public void insertLog(ConnectionLog log) {
        repository.insertLog(log);
    }

    /**
     * حذف السجل
     */
    public void deleteLog(ConnectionLog log) {
        repository.deleteLog(log);
    }

    /**
     * حذف جميع السجلات
     */
    public void deleteAllLogs() {
        repository.deleteAllLogs();
    }

    /**
     * حذف السجلات القديمة
     */
    public void deleteOldLogs() {
        repository.deleteOldLogs();
    }

    /**
     * عدد السجلات
     */
    public LiveData<Integer> getLogsCount() {
        return repository.getLogsCount();
    }
}