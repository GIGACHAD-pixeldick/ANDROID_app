package com.example.app.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class REQUETS_MODEL(
    @SerializedName("email") var email: String,
    @SerializedName("password") var password: String,
    @SerializedName("login") var login: String
)
