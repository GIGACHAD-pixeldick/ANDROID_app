package com.example.app.model

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface API {
    @POST("/signUp")
    fun getPosts(@Body Zhenya_Pidr: REQUETS_MODEL): Call<String>
    @POST("/signIn")
    fun getPosts2(@Body Zhenya_Gey: REQ_MOD_2): Call<AUTH_ANSWER>
}