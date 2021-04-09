package com.moviles.homework.retrofit

import retrofit2.http.GET

interface DogRetrofit {
    @GET("list")
    suspend fun get(): List<DogNetworkEntity>
}