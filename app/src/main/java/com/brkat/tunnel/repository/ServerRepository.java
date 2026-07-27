package com.brkat.tunnel.repository;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.brkat.tunnel.database.BrkatDatabase;
import com.brkat.tunnel.database.ServerDao;
import com.brkat.tunnel.models.Server;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * ServerRepository - مستودع البيانات للسيرفرات
 * يوفر طريقة موحدة للوصول إلى بيانات السيرفرات
 */
public class ServerRepository {

    private ServerDao serverDao;
    private Executor executor = Executors.newSingleThreadExecutor();

    public ServerRepository(Context context) {
        BrkatDatabase database = BrkatDatabase.getInstance(context);
        this.serverDao = database.serverDao();
    }

    /**
     * إدراج سيرفر جديد
     */
    public void insertServer(Server server) {
        executor.execute(() -> serverDao.insertServer(server));
    }

    /**
     * تحديث السيرفر
     */
    public void updateServer(Server server) {
        executor.execute(() -> serverDao.updateServer(server));
    }

    /**
     * حذف السيرفر
     */
    public void deleteServer(Server server) {
        executor.execute(() -> serverDao.deleteServer(server));
    }

    /**
     * الحصول على السيرفر بواسطة المعرّف
     */
    public LiveData<Server> getServerById(long serverId) {
        return serverDao.getServerById(serverId);
    }

    /**
     * الحصول على جميع السيرفرات
     */
    public LiveData<List<Server>> getAllServers() {
        return serverDao.getAllServers();
    }

    /**
     * الحصول على السيرفرات المفضلة
     */
    public LiveData<List<Server>> getFavoriteServers() {
        return serverDao.getFavoriteServers();
    }

    /**
     * البحث عن السيرفرات
     */
    public LiveData<List<Server>> searchServers(String query) {
        return serverDao.searchServers(query);
    }

    /**
     * الحصول على السيرفرات حسب البروتوكول
     */
    public LiveData<List<Server>> getServersByProtocol(String protocol) {
        return serverDao.getServersByProtocol(protocol);
    }

    /**
     * الحصول على السيرفرات حسب المجموعة
     */
    public LiveData<List<Server>> getServersByGroup(String groupName) {
        return serverDao.getServersByGroup(groupName);
    }

    /**
     * الحصول على جميع المجموعات
     */
    public LiveData<List<String>> getAllGroups() {
        return serverDao.getAllGroups();
    }

    /**
     * تحديث حالة المفضلة
     */
    public void updateFavoriteStatus(long serverId, boolean isFavorite) {
        executor.execute(() -> serverDao.updateFavoriteStatus(serverId, isFavorite));
    }

    /**
     * الحصول على السيرفر الأخير المستخدم
     */
    public LiveData<Server> getLastUsedServer() {
        return serverDao.getLastUsedServer();
    }

    /**
     * عدد السيرفرات
     */
    public LiveData<Integer> getServersCount() {
        return serverDao.getServersCount();
    }
}