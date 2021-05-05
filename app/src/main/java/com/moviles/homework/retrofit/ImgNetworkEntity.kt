package com.moviles.homework.retrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ImgNetworkEntity (
    @SerializedName("id")
    @Expose
    var id: String,

    @SerializedName("url")
    @Expose
    var url: String,

    @SerializedName("descripcion")
    @Expose
    var descripcion: String,

    @SerializedName("color")
    @Expose
    var color: String
)