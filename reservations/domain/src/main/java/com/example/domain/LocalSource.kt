package com.example.domain

interface LocalSource<T> {

    suspend fun save(t:  T)

    suspend fun load(): T?

}