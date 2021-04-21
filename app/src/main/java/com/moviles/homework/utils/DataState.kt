package com.moviles.homework.utils

import com.moviles.homework.model.Image
import java.lang.Exception

sealed class DataState{
    object  Idle: DataState()
    data class Success(val images: List<Image>) : DataState()
    data class Error(val exception: Exception) : DataState()
    object Loading: DataState()

}
