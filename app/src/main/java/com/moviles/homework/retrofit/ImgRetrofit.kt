package com.moviles.homework.retrofit

import retrofit2.http.GET

interface ImgRetrofit {
    @GET("list")
    suspend fun get(): List<ImgNetworkEntity>
}