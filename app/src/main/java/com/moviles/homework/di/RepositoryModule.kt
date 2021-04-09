package com.moviles.homework.di

import com.moviles.homework.repository.DogRepository
import com.moviles.homework.retrofit.DogRetrofit
import com.moviles.homework.retrofit.NetworkMapper
import com.moviles.homework.room.CacheMapper
import com.moviles.homework.room.DogDao
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
        dogDao : DogDao,
        dogRetrofit: DogRetrofit,
        cacheMapper: CacheMapper,
        networkMapper: NetworkMapper
    ): DogRepository {
        return DogRepository(dogDao, dogRetrofit, cacheMapper, networkMapper)
    }
}