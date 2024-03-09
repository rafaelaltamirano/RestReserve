package com.quandoo.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.quandoo.data.dao.TablesDao
import com.example.domain.Table

@Database(entities = [Table::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun TablesDao(): TablesDao
}