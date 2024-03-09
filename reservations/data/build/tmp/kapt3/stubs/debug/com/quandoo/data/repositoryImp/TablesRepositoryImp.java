package com.quandoo.data.repositoryImp;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0011\u0010\u000f\u001a\u00020\u0010H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J\u0011\u0010\n\u001a\u00020\u0003H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J\u001f\u0010\u0013\u001a\u00020\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0016"}, d2 = {"Lcom/quandoo/data/repositoryImp/TablesRepositoryImp;", "Lcom/quandoo/domain/repository/TablesRepository;", "tablesRemote", "error/NonExistentClass", "local", "Lcom/quandoo/domain/data_source/local/TablesLocalSource;", "(Lerror/NonExistentClass;Lcom/quandoo/domain/data_source/local/TablesLocalSource;)V", "tables", "", "Lcom/quandoo/domain/Table;", "getTables", "()Ljava/util/List;", "setTables", "(Ljava/util/List;)V", "Lerror/NonExistentClass;", "clear", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "save", "t", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_debug"})
public final class TablesRepositoryImp implements com.quandoo.domain.repository.TablesRepository {
    @org.jetbrains.annotations.NotNull
    private final error.NonExistentClass tablesRemote = null;
    @org.jetbrains.annotations.NotNull
    private final com.quandoo.domain.data_source.local.TablesLocalSource local = null;
    @org.jetbrains.annotations.NotNull
    private java.util.List<com.quandoo.domain.Table> tables;
    
    public TablesRepositoryImp(@org.jetbrains.annotations.NotNull
    error.NonExistentClass tablesRemote, @org.jetbrains.annotations.NotNull
    com.quandoo.domain.data_source.local.TablesLocalSource local) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.quandoo.domain.Table> getTables() {
        return null;
    }
    
    public final void setTables(@org.jetbrains.annotations.NotNull
    java.util.List<com.quandoo.domain.Table> p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getTables(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super error.NonExistentClass> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public java.lang.Object save(@org.jetbrains.annotations.NotNull
    java.util.List<com.quandoo.domain.Table> t, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public java.lang.Object load(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.quandoo.domain.Table>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public java.lang.Object clear(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}