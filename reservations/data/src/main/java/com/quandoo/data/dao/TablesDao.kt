package com.quandoo.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.domain.model.Table

@Dao
interface TablesDao {

    @Query("SELECT * FROM tables")
    suspend fun getAll(): List<Table>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(banks: List<Table>)
}