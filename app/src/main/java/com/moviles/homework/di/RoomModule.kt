package com.moviles.homework.di

import android.content.Context
import androidx.room.Room
import com.moviles.homework.room.ImgDao
import com.moviles.homework.room.ImgDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object RoomModule {

    @Singleton
    @Provides
    fun provideDogDb(@ApplicationContext context: Context): ImgDatabase {
        return Room
            .databaseBuilder(context, ImgDatabase::class.java, ImgDatabase.DATABASE_NAME).fallbackToDestructiveMigration().build()
    }

    @Singleton
    @Provides
    fun provideDogDao(imgDatabase: ImgDatabase): ImgDao {
        return imgDatabase.ImgDao()
    }
}