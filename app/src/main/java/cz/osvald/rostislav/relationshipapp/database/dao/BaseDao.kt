package cz.osvald.rostislav.relationshipapp.database.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update


interface BaseDao<T> {
    @Insert
    suspend fun insert(vararg users: T)

    @Update
    suspend fun update(vararg users: T)

    @Delete
    suspend fun delete(vararg users: T)
}