package com.lon.net

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RequestManger {
    private const val DEFAULT_TIME_OUT = 15
    private var BASE_URL = ""
    private fun buildOkHttpclient(): OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(DEFAULT_TIME_OUT.toLong(), TimeUnit.SECONDS)
        .writeTimeout(DEFAULT_TIME_OUT.toLong(), TimeUnit.SECONDS)
        .readTimeout(DEFAULT_TIME_OUT.toLong(), TimeUnit.SECONDS)
        .addInterceptor(
            HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT).setLevel(
                HttpLoggingInterceptor.Level.BODY
            )
        )
        .build()

    private val request: Retrofit by lazy {
        if (BASE_URL.isEmpty()) {
            throw Exception("URL IS NULL !")
        }
        Retrofit.Builder()
            .client(buildOkHttpclient())
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
    }

    fun <T> create(clazz: Class<T>): T =
        request.create(clazz)

    fun init(uer: String) {
        BASE_URL = uer
    }

}

