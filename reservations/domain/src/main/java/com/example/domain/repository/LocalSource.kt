package com.example.domain.repository

interface LocalSource<T> {

    suspend fun save(t:  T)

    suspend fun load(): T?

}