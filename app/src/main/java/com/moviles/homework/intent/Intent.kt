package com.moviles.homework.intent

sealed class Intent{
    object GetDogEvent: Intent()
    object None: Intent()
}
