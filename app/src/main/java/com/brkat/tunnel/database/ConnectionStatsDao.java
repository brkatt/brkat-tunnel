package com.brkat.tunnel.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.brkat.tunnel.models.ConnectionStats;

import java.util.List;

/**
 * ConnectionStatsDao - واجهة الوصول لقاعدة بيانات إحصائيات الاتصال
 */
@Dao
public interface ConnectionStatsDao {

    @Insert
    long insertStats(ConnectionStats stats);

    @Update
    void updateStats(ConnectionStats stats);

    @Delete
    void deleteStats(ConnectionStats stats);

    @Query("SELECT * FROM connection_stats WHERE id = :statsId")
    LiveData<ConnectionStats> getStatsById(long statsId);

    @Query("SELECT * FROM connection_stats WHERE serverId = :serverId ORDER BY timestamp DESC LIMIT 1")
    LiveData<ConnectionStats> getLatestStatsForServer(long serverId);

    @Query("SELECT * FROM connection_stats WHERE serverId = :serverId AND timestamp > (SELECT MAX(timestamp) - 3600000 FROM connection_stats) ORDER BY timestamp DESC")
    LiveData<List<ConnectionStats>> getStatsLastHour(long serverId);

    @Query("SELECT * FROM connection_stats WHERE serverId = :serverId AND timestamp > (SELECT MAX(timestamp) - 86400000 FROM connection_stats) ORDER BY timestamp DESC")
    LiveData<List<ConnectionStats>> getStatsLastDay(long serverId);

    @Query("DELETE FROM connection_stats WHERE timestamp < (SELECT MAX(timestamp) - 2592000000 FROM connection_stats)")
    void deleteOldStats();

    @Query("DELETE FROM connection_stats WHERE serverId = :serverId")
    void deleteStatsForServer(long serverId);
}