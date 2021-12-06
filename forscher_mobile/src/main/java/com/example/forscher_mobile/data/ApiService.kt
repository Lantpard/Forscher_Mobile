package com.example.forscher_mobile.data

import com.example.forscher_mobile.model.Poi
import retrofit2.http.GET

interface ApiService {
    @GET("Lantpard/Forscher_Mobile/poi")
    suspend fun getPoi(): Poi

}