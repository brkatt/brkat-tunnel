package com.brkat.tunnel.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.brkat.tunnel.models.Server;

import java.util.List;

/**
 * ServerDao - واجهة الوصول لقاعدة بيانات السيرفرات
 * تحتوي على جميع العمليات على جدول السيرفرات
 */
@Dao
public interface ServerDao {

    @Insert
    long insertServer(Server server);

    @Update
    void updateServer(Server server);

    @Delete
    void deleteServer(Server server);

    @Query("SELECT * FROM servers WHERE id = :serverId")
    LiveData<Server> getServerById(long serverId);

    @Query("SELECT * FROM servers ORDER BY sortOrder ASC")
    LiveData<List<Server>> getAllServers();

    @Query("SELECT * FROM servers WHERE isFavorite = 1 ORDER BY sortOrder ASC")
    LiveData<List<Server>> getFavoriteServers();

    @Query("SELECT * FROM servers WHERE protocol = :protocol ORDER BY sortOrder ASC")
    LiveData<List<Server>> getServersByProtocol(String protocol);

    @Query("SELECT * FROM servers WHERE name LIKE '%' || :query || '%' OR address LIKE '%' || :query || '%' ORDER BY sortOrder ASC")
    LiveData<List<Server>> searchServers(String query);

    @Query("SELECT * FROM servers WHERE groupName = :groupName ORDER BY sortOrder ASC")
    LiveData<List<Server>> getServersByGroup(String groupName);

    @Query("SELECT DISTINCT groupName FROM servers WHERE groupName IS NOT NULL")
    LiveData<List<String>> getAllGroups();

    @Query("DELETE FROM servers")
    void deleteAllServers();

    @Query("SELECT COUNT(*) FROM servers")
    LiveData<Integer> getServersCount();

    @Query("UPDATE servers SET isFavorite = :isFavorite WHERE id = :serverId")
    void updateFavoriteStatus(long serverId, boolean isFavorite);

    @Query("SELECT * FROM servers ORDER BY updatedAt DESC LIMIT 1")
    LiveData<Server> getLastUsedServer();
}