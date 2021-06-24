package ir.ah.newsapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ir.ah.newsapp.data.model.remotekey.*

@Dao
interface RemoteKeysDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(remoteKey: List<RemoteKeys>)

    @Query("SELECT * FROM remotekeys WHERE repoId = :id")
    suspend fun remoteKeysArticleId(id: String): RemoteKeys?

    @Query("DELETE FROM remotekeys")
    suspend fun clearRemoteKeys()
}

