package com.moviles.homework.retrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class DogNetworkEntity (
    @SerializedName("id")
    @Expose
    var id: String,

    @SerializedName("download_url")
    @Expose
    var url: String,

    @SerializedName("width")
    @Expose
    var width: Int,

    @SerializedName("height")
    @Expose
    var height: Int
)