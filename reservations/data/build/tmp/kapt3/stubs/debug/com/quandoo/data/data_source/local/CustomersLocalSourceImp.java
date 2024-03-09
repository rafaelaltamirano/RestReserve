package com.quandoo.data.data_source.local;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0011\u0010\u0005\u001a\u00020\u0006H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J\u001f\u0010\u000b\u001a\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000e"}, d2 = {"Lcom/quandoo/data/data_source/local/CustomersLocalSourceImp;", "Lcom/quandoo/domain/data_source/local/CustomersLocalSource;", "customersDao", "Lcom/quandoo/data/dao/CustomersDao;", "(Lcom/quandoo/data/dao/CustomersDao;)V", "clear", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "", "Lcom/quandoo/domain/Customer;", "save", "t", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_debug"})
public final class CustomersLocalSourceImp implements com.quandoo.domain.data_source.local.CustomersLocalSource {
    @org.jetbrains.annotations.NotNull
    private final com.quandoo.data.dao.CustomersDao customersDao = null;
    
    @javax.inject.Inject
    public CustomersLocalSourceImp(@org.jetbrains.annotations.NotNull
    com.quandoo.data.dao.CustomersDao customersDao) {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object save(@org.jetbrains.annotations.NotNull
    java.util.List<com.quandoo.domain.Customer> t, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object load(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.quandoo.domain.Customer>> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object clear(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}