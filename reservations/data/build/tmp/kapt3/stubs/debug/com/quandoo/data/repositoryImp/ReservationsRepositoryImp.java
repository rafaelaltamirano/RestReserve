package com.quandoo.data.repositoryImp;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0019\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J(\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u0012H\u0096@\u00f8\u0001\u0001\u00f8\u0001\u0002\u00f8\u0001\u0000\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u000bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017J\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014J\u001f\u0010\u0019\u001a\u00020\r2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u001c"}, d2 = {"Lcom/quandoo/data/repositoryImp/ReservationsRepositoryImp;", "Lcom/example/domain/repository/ReservationsRepository;", "reservationDao", "Lcom/quandoo/data/dao/ReservationsDao;", "tablesDao", "Lcom/quandoo/data/dao/TablesDao;", "api", "Lcom/quandoo/data/api/RestaurantApi;", "(Lcom/quandoo/data/dao/ReservationsDao;Lcom/quandoo/data/dao/TablesDao;Lcom/quandoo/data/api/RestaurantApi;)V", "reservations", "", "Lcom/example/domain/model/Reservation;", "deleteReservationById", "", "reservationId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getReservations", "Lkotlin/Result;", "getReservations-IoAF18A", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertReservation", "reservation", "(Lcom/example/domain/model/Reservation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "save", "t", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_debug"})
public final class ReservationsRepositoryImp implements com.example.domain.repository.ReservationsRepository {
    @org.jetbrains.annotations.NotNull
    private final com.quandoo.data.dao.ReservationsDao reservationDao = null;
    @org.jetbrains.annotations.NotNull
    private final com.quandoo.data.dao.TablesDao tablesDao = null;
    @org.jetbrains.annotations.NotNull
    private final com.quandoo.data.api.RestaurantApi api = null;
    @org.jetbrains.annotations.NotNull
    private java.util.List<com.example.domain.model.Reservation> reservations;
    
    public ReservationsRepositoryImp(@org.jetbrains.annotations.NotNull
    com.quandoo.data.dao.ReservationsDao reservationDao, @org.jetbrains.annotations.NotNull
    com.quandoo.data.dao.TablesDao tablesDao, @org.jetbrains.annotations.NotNull
    com.quandoo.data.api.RestaurantApi api) {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object deleteReservationById(int reservationId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object insertReservation(@org.jetbrains.annotations.NotNull
    com.example.domain.model.Reservation reservation, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object save(@org.jetbrains.annotations.NotNull
    java.util.List<com.example.domain.model.Reservation> t, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object load(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.example.domain.model.Reservation>> $completion) {
        return null;
    }
}