package com.moviles.homework.intent

sealed class Intent{
    object GetImgEvent: Intent()
    object None: Intent()
}
