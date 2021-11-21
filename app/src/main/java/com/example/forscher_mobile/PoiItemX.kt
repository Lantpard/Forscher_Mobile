package com.example.forscher_mobile


import com.google.gson.annotations.SerializedName

data class PoiItemX(
    @SerializedName("description")
    val description: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("ranking")
    val ranking: Float,
    @SerializedName("urlPicture")
    val urlPicture: String
)