package com.example.forscher_mobile.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class PoiItemX(
    @SerializedName("description")
    val description: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("ranking")
    val ranking: Float,
    @SerializedName("urlPicture")
    val urlPicture: String,
    @SerializedName("general")
    val general: String,
    @SerializedName("location")
    val location: String,
    @SerializedName("temperature")
    val temperature: String,
    @SerializedName("recommendations")
    val recommendations: String
) : Serializable