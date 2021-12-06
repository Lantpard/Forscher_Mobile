package com.example.forscher_mobile.data

class PoiRepository {
    suspend fun getPoi()=ApiFactory.retrofit.getPoi()
}