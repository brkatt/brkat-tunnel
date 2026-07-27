package com.brkat.tunnel.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.brkat.tunnel.models.ConnectionLog;

import java.util.List;

/**
 * ConnectionLogDao - واجهة الوصول لقاعدة بيانات سجلات الاتصال
 */
@Dao
public interface ConnectionLogDao {

    @Insert
    long insertLog(ConnectionLog log);

    @Delete
    void deleteLog(ConnectionLog log);

    @Query("SELECT * FROM connection_logs WHERE serverId = :serverId ORDER BY timestamp DESC")
    LiveData<List<ConnectionLog>> getLogsForServer(long serverId);

    @Query("SELECT * FROM connection_logs ORDER BY timestamp DESC LIMIT 100")
    LiveData<List<ConnectionLog>> getLatestLogs();

    @Query("SELECT * FROM connection_logs WHERE timestamp > (SELECT MAX(timestamp) - 3600000 FROM connection_logs) ORDER BY timestamp DESC")
    LiveData<List<ConnectionLog>> getLogsLastHour();

    @Query("SELECT * FROM connection_logs WHERE message LIKE '%' || :query || '%' OR errorDetails LIKE '%' || :query || '%' ORDER BY timestamp DESC")
    LiveData<List<ConnectionLog>> searchLogs(String query);

    @Query("DELETE FROM connection_logs WHERE timestamp < (SELECT MAX(timestamp) - 604800000 FROM connection_logs)")
    void deleteOldLogs();

    @Query("DELETE FROM connection_logs")
    void deleteAllLogs();

    @Query("SELECT COUNT(*) FROM connection_logs")
    LiveData<Integer> getLogsCount();
}