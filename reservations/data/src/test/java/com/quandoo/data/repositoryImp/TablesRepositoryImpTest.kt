package com.quandoo.data.repositoryImp

import com.google.common.truth.Truth.assertThat
import com.quandoo.data.api.RestaurantApi
import com.quandoo.data.response.tablesResponse
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit


class TablesRepositoryImpTest {

    private lateinit var repository: TablesRepositoryImp
    private lateinit var mockWebServer: MockWebServer
    private lateinit var okHttpClient: OkHttpClient
    private lateinit var api: RestaurantApi

    @Before
    fun setUp() {
        mockWebServer = MockWebServer()
        okHttpClient = OkHttpClient.Builder()
            .writeTimeout(1, TimeUnit.SECONDS)
            .readTimeout(1, TimeUnit.SECONDS)
            .connectTimeout(1, TimeUnit.SECONDS)
            .build()
        api = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .client(okHttpClient)
            .baseUrl(mockWebServer.url("/"))
            .build()
            .create(RestaurantApi::class.java)
        repository = TablesRepositoryImp(
            dao = mockk(relaxed = true),
            api = api
        )
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }

    @Test
    fun `Get tables, valid response, returns results`() = runBlocking {
        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(200)
                .setBody(tablesResponse)
        )
        val result = repository.getTables()

        assertThat(result.isSuccess).isTrue()
    }

    @Test
    fun `Get tables, invalid response, returns failure`() = runBlocking {

        coEvery { repository.load() } returns emptyList()

        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(403)
                .setBody(tablesResponse)
        )
        val result = repository.getTables()

        assertThat(result.isFailure).isTrue()
    }





}