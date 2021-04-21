package com.moviles.homework.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ImgCacheEntity::class], version = 1)
abstract class ImgDatabase : RoomDatabase() {
    companion object{
        val DATABASE_NAME = "ImgDB"
    }

    abstract fun ImgDao(): ImgDao
}