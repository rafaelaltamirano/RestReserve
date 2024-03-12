package com.quandoo.data.repositoryImp;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J(\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u000bH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00f8\u0001\u0002\u00f8\u0001\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0096@\u00f8\u0001\u0002\u00a2\u0006\u0002\u0010\rJ\u001f\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0096@\u00f8\u0001\u0002\u00a2\u0006\u0002\u0010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\n\u0002\b\u0019\u00a8\u0006\u0013"}, d2 = {"Lcom/quandoo/data/repositoryImp/CustomersRepositoryImp;", "Lcom/example/domain/repository/CustomersRepository;", "dao", "Lcom/quandoo/data/dao/CustomersDao;", "api", "Lcom/quandoo/data/api/RestaurantApi;", "(Lcom/quandoo/data/dao/CustomersDao;Lcom/quandoo/data/api/RestaurantApi;)V", "customers", "", "Lcom/example/domain/model/Customer;", "getCustomers", "Lkotlin/Result;", "getCustomers-IoAF18A", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "save", "", "t", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_debug"})
public final class CustomersRepositoryImp implements com.example.domain.repository.CustomersRepository {
    @org.jetbrains.annotations.NotNull
    private final com.quandoo.data.dao.CustomersDao dao = null;
    @org.jetbrains.annotations.NotNull
    private final com.quandoo.data.api.RestaurantApi api = null;
    @org.jetbrains.annotations.NotNull
    private java.util.List<com.example.domain.model.Customer> customers;
    
    public CustomersRepositoryImp(@org.jetbrains.annotations.NotNull
    com.quandoo.data.dao.CustomersDao dao, @org.jetbrains.annotations.NotNull
    com.quandoo.data.api.RestaurantApi api) {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object save(@org.jetbrains.annotations.NotNull
    java.util.List<com.example.domain.model.Customer> t, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object load(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.example.domain.model.Customer>> $completion) {
        return null;
    }
}