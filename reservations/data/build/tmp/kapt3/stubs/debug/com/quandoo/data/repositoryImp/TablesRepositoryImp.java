package com.quandoo.data.repositoryImp;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J(\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u000eH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00f8\u0001\u0002\u00f8\u0001\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0096@\u00f8\u0001\u0002\u00a2\u0006\u0002\u0010\u0010J\u001f\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0096@\u00f8\u0001\u0002\u00a2\u0006\u0002\u0010\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u0082\u0002\u000f\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\n\u0002\b\u0019\u00a8\u0006\u0016"}, d2 = {"Lcom/quandoo/data/repositoryImp/TablesRepositoryImp;", "Lcom/example/domain/repository/TablesRepository;", "dao", "Lcom/quandoo/data/dao/TablesDao;", "api", "Lcom/quandoo/data/api/RestaurantApi;", "(Lcom/quandoo/data/dao/TablesDao;Lcom/quandoo/data/api/RestaurantApi;)V", "tables", "", "Lcom/example/domain/model/Table;", "getTables", "()Ljava/util/List;", "setTables", "(Ljava/util/List;)V", "Lkotlin/Result;", "getTables-IoAF18A", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "save", "", "t", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_debug"})
public final class TablesRepositoryImp implements com.example.domain.repository.TablesRepository {
    @org.jetbrains.annotations.NotNull
    private final com.quandoo.data.dao.TablesDao dao = null;
    @org.jetbrains.annotations.NotNull
    private final com.quandoo.data.api.RestaurantApi api = null;
    @org.jetbrains.annotations.NotNull
    private java.util.List<com.example.domain.model.Table> tables;
    
    public TablesRepositoryImp(@org.jetbrains.annotations.NotNull
    com.quandoo.data.dao.TablesDao dao, @org.jetbrains.annotations.NotNull
    com.quandoo.data.api.RestaurantApi api) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.example.domain.model.Table> getTables() {
        return null;
    }
    
    public final void setTables(@org.jetbrains.annotations.NotNull
    java.util.List<com.example.domain.model.Table> p0) {
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object save(@org.jetbrains.annotations.NotNull
    java.util.List<com.example.domain.model.Table> t, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object load(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.example.domain.model.Table>> $completion) {
        return null;
    }
}