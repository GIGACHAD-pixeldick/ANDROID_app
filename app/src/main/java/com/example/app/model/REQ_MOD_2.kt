package com.example.app.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class REQ_MOD_2(
    @SerializedName("email") @Expose var email: String,
    @SerializedName("password") @Expose var password: String
)
