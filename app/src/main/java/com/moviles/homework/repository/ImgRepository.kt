package com.moviles.homework.repository

import com.moviles.homework.retrofit.ImgRetrofit
import com.moviles.homework.retrofit.NetworkMapper
import com.moviles.homework.room.CacheMapper
import com.moviles.homework.room.ImgDao
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import com.moviles.homework.utils.DataState

class ImgRepository constructor(
    private val imgDao: ImgDao,
    private val imgRetrofit: ImgRetrofit,
    private val cacheMapper: CacheMapper,
    private val networkMapper: NetworkMapper
){
    suspend fun getImg(): Flow<DataState> = flow {
        emit(DataState.Loading)
        delay(1000)
        try {
            val imgData = imgRetrofit.get()
            val imgMap = networkMapper.mapFromEntityList(imgData)
            for (tempImg in imgMap){
                imgDao.insert(cacheMapper.mapToEntity(tempImg))
            }
            val cacheImg = imgDao.get()
            emit(DataState.Success(cacheMapper.mapFromEntityList(cacheImg)))
        } catch (e: Exception){
            emit(DataState.Error(e))
        }
    }
}