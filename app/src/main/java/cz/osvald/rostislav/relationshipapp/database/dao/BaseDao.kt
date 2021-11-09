package cz.osvald.rostislav.relationshipapp.database.dao

import androidx.room.Delete
import androidx.room.Insert


interface BaseDao<T> {
    @Insert
    fun insertAll(vararg users: T)

    @Delete
    fun delete(user: T)
}