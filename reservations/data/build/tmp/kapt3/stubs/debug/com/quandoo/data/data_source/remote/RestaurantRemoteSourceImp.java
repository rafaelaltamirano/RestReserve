package com.quandoo.data.data_source.remote;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0006H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0006H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\r"}, d2 = {"Lcom/quandoo/data/data_source/remote/RestaurantRemoteSourceImp;", "", "api", "Lcom/quandoo/data/api/RestaurantApi;", "(Lcom/quandoo/data/api/RestaurantApi;)V", "getCustomers", "", "Lcom/quandoo/domain/Customer;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getReservations", "Lcom/quandoo/domain/Reservation;", "getTables", "Lcom/quandoo/domain/Table;", "data_debug"})
public final class RestaurantRemoteSourceImp {
    @org.jetbrains.annotations.NotNull
    private final com.quandoo.data.api.RestaurantApi api = null;
    
    @javax.inject.Inject
    public RestaurantRemoteSourceImp(@org.jetbrains.annotations.NotNull
    com.quandoo.data.api.RestaurantApi api) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getTables(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.quandoo.domain.Table>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getReservations(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.quandoo.domain.Reservation>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getCustomers(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.quandoo.domain.Customer>> $completion) {
        return null;
    }
}