package com.quandoo.data.database;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\fX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/quandoo/data/database/RestaurantDatabaseTest;", "Landroidx/room/RoomDatabase;", "()V", "customersDao", "Lcom/quandoo/data/dao/CustomersDao;", "getCustomersDao", "()Lcom/quandoo/data/dao/CustomersDao;", "reservationsDao", "Lcom/quandoo/data/dao/ReservationsDao;", "getReservationsDao", "()Lcom/quandoo/data/dao/ReservationsDao;", "tablesDao", "Lcom/quandoo/data/dao/TablesDao;", "getTablesDao", "()Lcom/quandoo/data/dao/TablesDao;", "data_debug"})
@androidx.room.Database(entities = {com.example.domain.model.Table.class, com.example.domain.model.Customer.class, com.example.domain.model.Reservation.class}, version = 1, exportSchema = false)
public abstract class RestaurantDatabaseTest extends androidx.room.RoomDatabase {
    
    public RestaurantDatabaseTest() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public abstract com.quandoo.data.dao.TablesDao getTablesDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.quandoo.data.dao.CustomersDao getCustomersDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.quandoo.data.dao.ReservationsDao getReservationsDao();
}