package cz.osvald.rostislav.relationshipapp.database.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update


interface BaseDao<T> {
    @Insert
    fun insert(vararg users: T)

    @Update
    fun update(vararg users: T)

    @Delete
    fun delete(vararg users: T)
}