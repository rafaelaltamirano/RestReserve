package com.quandoo.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.domain.model.Customer

@Dao
interface CustomersDao {

    @Query("SELECT * FROM  customers")
    suspend fun getAll(): List<Customer>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(customer: List<Customer>)
}