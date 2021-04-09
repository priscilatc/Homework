package com.moviles.homework.room

import androidx.room.*

@Dao
interface DogDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(dogEntity: DogCacheEntity): Long
    @Query("select * from dog")
    suspend fun get(): List<DogCacheEntity>
}