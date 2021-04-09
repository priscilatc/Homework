package com.moviles.homework.repository

import com.moviles.homework.retrofit.DogRetrofit
import com.moviles.homework.retrofit.NetworkMapper
import com.moviles.homework.room.CacheMapper
import com.moviles.homework.room.DogDao
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import com.moviles.homework.utils.DataState

class DogRepository constructor(
    private val dogDao: DogDao,
    private val dogRetrofit: DogRetrofit,
    private val cacheMapper: CacheMapper,
    private val networkMapper: NetworkMapper
){
    suspend fun getImg(): Flow<DataState> = flow {
        emit(DataState.Loading)
        delay(1000)
        try {
            val dogData = dogRetrofit.get()
            val dogMap = networkMapper.mapFromEntityList(dogData)
            for (tempDog in dogMap){
                dogDao.insert(cacheMapper.mapToEntity(tempDog))
            }
            val cacheDog = dogDao.get()
            emit(DataState.Success(cacheMapper.mapFromEntityList(cacheDog)))
        } catch (e: Exception){
            emit(DataState.Error(e))
        }
    }
}