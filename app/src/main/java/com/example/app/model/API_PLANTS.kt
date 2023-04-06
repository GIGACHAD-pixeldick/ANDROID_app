package com.example.app.model

import retrofit2.Call
import retrofit2.http.GET

interface API_PLANTS {
    @GET("/plants")
    fun getPlants(): Call<List<InfPlant>>
}