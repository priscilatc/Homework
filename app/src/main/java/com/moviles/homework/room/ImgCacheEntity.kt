package com.moviles.homework.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "img")
class ImgCacheEntity (
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name= "id")
    var id: String,
    @ColumnInfo(name = "url")
    var url: String,
    @ColumnInfo(name = "descripcion")
    var descripcion: String,
    @ColumnInfo(name = "color")
    var color: String

)