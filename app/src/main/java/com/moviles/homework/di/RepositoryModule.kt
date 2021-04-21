package com.moviles.homework.di

import com.moviles.homework.repository.ImgRepository
import com.moviles.homework.retrofit.ImgRetrofit
import com.moviles.homework.retrofit.NetworkMapper
import com.moviles.homework.room.CacheMapper
import com.moviles.homework.room.ImgDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object RepositoryModule {

    @Singleton
    @Provides
    fun provideDogRepository(
        imgDao : ImgDao,
        imgRetrofit: ImgRetrofit,
        cacheMapper: CacheMapper,
        networkMapper: NetworkMapper
    ): ImgRepository {
        return ImgRepository(imgDao, imgRetrofit, cacheMapper, networkMapper)
    }
}