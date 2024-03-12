package com.quandoo.data.api;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bJ\u001d\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u001d\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00040\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00040\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\f"}, d2 = {"Lcom/quandoo/data/api/RestaurantApi;", "", "getCustomer", "Lretrofit2/Response;", "", "Lcom/quandoo/data/remote/dto/CustomerDto;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getReservations", "Lcom/quandoo/data/remote/dto/ReservationDto;", "getTables", "Lcom/example/domain/model/Table;", "Companion", "data_debug"})
public abstract interface RestaurantApi {
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String BASE_URL = "https://s3-eu-west-1.amazonaws.com/";
    @org.jetbrains.annotations.NotNull
    public static final com.quandoo.data.api.RestaurantApi.Companion Companion = null;
    
    @retrofit2.http.GET(value = "quandoo-assessment/tables.json")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getTables(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.example.domain.model.Table>>> $completion);
    
    @retrofit2.http.GET(value = "quandoo-assessment/customers.json")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getCustomer(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.quandoo.data.remote.dto.CustomerDto>>> $completion);
    
    @retrofit2.http.GET(value = "quandoo-assessment/reservations.json")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getReservations(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.quandoo.data.remote.dto.ReservationDto>>> $completion);
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/quandoo/data/api/RestaurantApi$Companion;", "", "()V", "BASE_URL", "", "data_debug"})
    public static final class Companion {
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String BASE_URL = "https://s3-eu-west-1.amazonaws.com/";
        
        private Companion() {
            super();
        }
    }
}