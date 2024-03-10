package com.quandoo.data.repositoryImp;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J(\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0013H\u0096@\u00f8\u0001\u0001\u00f8\u0001\u0002\u00f8\u0001\u0000\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\tH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0018J\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015J\u001f\u0010\u001a\u001a\u00020\u000f2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001cR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u001d"}, d2 = {"Lcom/quandoo/data/repositoryImp/ReservationsRepositoryImp;", "Lcom/example/domain/repository/ReservationsRepository;", "dao", "Lcom/quandoo/data/dao/ReservationsDao;", "api", "Lcom/quandoo/data/api/RestaurantApi;", "(Lcom/quandoo/data/dao/ReservationsDao;Lcom/quandoo/data/api/RestaurantApi;)V", "reservations", "", "Lcom/example/domain/model/Reservation;", "getReservations", "()Ljava/util/List;", "setReservations", "(Ljava/util/List;)V", "deleteReservationById", "", "reservationId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Result;", "getReservations-IoAF18A", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertReservation", "reservation", "(Lcom/example/domain/model/Reservation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "save", "t", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_debug"})
public final class ReservationsRepositoryImp implements com.example.domain.repository.ReservationsRepository {
    @org.jetbrains.annotations.NotNull
    private final com.quandoo.data.dao.ReservationsDao dao = null;
    @org.jetbrains.annotations.NotNull
    private final com.quandoo.data.api.RestaurantApi api = null;
    @org.jetbrains.annotations.NotNull
    private java.util.List<com.example.domain.model.Reservation> reservations;
    
    public ReservationsRepositoryImp(@org.jetbrains.annotations.NotNull
    com.quandoo.data.dao.ReservationsDao dao, @org.jetbrains.annotations.NotNull
    com.quandoo.data.api.RestaurantApi api) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.example.domain.model.Reservation> getReservations() {
        return null;
    }
    
    public final void setReservations(@org.jetbrains.annotations.NotNull
    java.util.List<com.example.domain.model.Reservation> p0) {
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