package com.moviles.homework.room

import androidx.room.*

@Dao
interface ImgDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(imgEntity: ImgCacheEntity): Long
    @Query("select * from img")
    suspend fun get(): List<ImgCacheEntity>
}