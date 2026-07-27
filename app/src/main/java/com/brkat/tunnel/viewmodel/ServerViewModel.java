package com.brkat.tunnel.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.brkat.tunnel.models.Server;
import com.brkat.tunnel.repository.ServerRepository;

import java.util.List;

/**
 * ServerViewModel - نموذج العرض للسيرفرات
 * يدير بيانات السيرفرات ويوفرها للواجهات
 */
public class ServerViewModel extends AndroidViewModel {

    private ServerRepository repository;
    private LiveData<List<Server>> allServers;
    private LiveData<List<Server>> favoriteServers;

    public ServerViewModel(Application application) {
        super(application);
        repository = new ServerRepository(application);
        allServers = repository.getAllServers();
        favoriteServers = repository.getFavoriteServers();
    }

    /**
     * الحصول على جميع السيرفرات
     */
    public LiveData<List<Server>> getAllServers() {
        return allServers;
    }

    /**
     * الحصول على السيرفرات المفضلة
     */
    public LiveData<List<Server>> getFavoriteServers() {
        return favoriteServers;
    }

    /**
     * البحث عن السيرفرات
     */
    public LiveData<List<Server>> searchServers(String query) {
        return repository.searchServers(query);
    }

    /**
     * إدراج سيرفر
     */
    public void insertServer(Server server) {
        repository.insertServer(server);
    }

    /**
     * تحديث السيرفر
     */
    public void updateServer(Server server) {
        repository.updateServer(server);
    }

    /**
     * حذف السيرفر
     */
    public void deleteServer(Server server) {
        repository.deleteServer(server);
    }

    /**
     * تحديث حالة المفضلة
     */
    public void updateFavoriteStatus(long serverId, boolean isFavorite) {
        repository.updateFavoriteStatus(serverId, isFavorite);
    }
}