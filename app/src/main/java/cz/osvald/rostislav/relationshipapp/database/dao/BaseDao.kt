package cz.osvald.rostislav.relationshipapp.database.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update


interface BaseDao<T> {
    @Insert
    fun insertAll(vararg users: T)

    @Update
    fun updateAll(vararg users: T)

    @Delete
    fun delete(user: T)
}