package com.quandoo.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.domain.model.Customer
import com.example.domain.model.Reservation
import com.example.domain.model.Table
import com.quandoo.data.dao.CustomersDao
import com.quandoo.data.dao.ReservationsDao
import com.quandoo.data.dao.TablesDao

@Database(entities = [Table::class, Customer::class, Reservation::class], version = 1, exportSchema = false)
abstract class RestaurantDatabaseTest : RoomDatabase() {
    abstract val tablesDao: TablesDao
    abstract val customersDao: CustomersDao
    abstract val reservationsDao: ReservationsDao
}
