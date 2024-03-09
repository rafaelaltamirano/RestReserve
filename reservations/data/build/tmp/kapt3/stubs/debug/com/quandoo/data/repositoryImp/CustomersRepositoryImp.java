package com.quandoo.data.repositoryImp;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0011\u0010\u000f\u001a\u00020\u0010H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J\u0011\u0010\u0012\u001a\u00020\u0003H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J\u001f\u0010\u0014\u001a\u00020\u00102\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0017"}, d2 = {"Lcom/quandoo/data/repositoryImp/CustomersRepositoryImp;", "Lcom/quandoo/domain/repository/CustomersRepository;", "remote", "error/NonExistentClass", "local", "Lcom/quandoo/domain/data_source/local/CustomersLocalSource;", "(Lerror/NonExistentClass;Lcom/quandoo/domain/data_source/local/CustomersLocalSource;)V", "customer", "", "Lcom/quandoo/domain/Customer;", "getCustomer", "()Ljava/util/List;", "setCustomer", "(Ljava/util/List;)V", "Lerror/NonExistentClass;", "clear", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCustomers", "load", "save", "t", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_debug"})
public final class CustomersRepositoryImp implements com.quandoo.domain.repository.CustomersRepository {
    @org.jetbrains.annotations.NotNull
    private final error.NonExistentClass remote = null;
    @org.jetbrains.annotations.NotNull
    private final com.quandoo.domain.data_source.local.CustomersLocalSource local = null;
    @org.jetbrains.annotations.NotNull
    private java.util.List<com.quandoo.domain.Customer> customer;
    
    public CustomersRepositoryImp(@org.jetbrains.annotations.NotNull
    error.NonExistentClass remote, @org.jetbrains.annotations.NotNull
    com.quandoo.domain.data_source.local.CustomersLocalSource local) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.quandoo.domain.Customer> getCustomer() {
        return null;
    }
    
    public final void setCustomer(@org.jetbrains.annotations.NotNull
    java.util.List<com.quandoo.domain.Customer> p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getCustomers(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super error.NonExistentClass> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public java.lang.Object save(@org.jetbrains.annotations.NotNull
    java.util.List<com.quandoo.domain.Customer> t, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public java.lang.Object load(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.quandoo.domain.Customer>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public java.lang.Object clear(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}