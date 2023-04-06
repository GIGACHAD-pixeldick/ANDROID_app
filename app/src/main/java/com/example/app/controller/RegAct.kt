package com.example.app.controller

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.app.R
import com.example.app.model.API
import com.example.app.model.REQUETS_MODEL
import kotlinx.android.synthetic.main.activity_auth.*
import kotlinx.android.synthetic.main.activity_main.button
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

class RegAct : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        button.setOnClickListener {
            startActivity(Intent(this@RegAct, PlantsAct::class.java))
            finish()
            val login = username.text.toString()
            val pochta = email.text.toString()
            val parol = password.text.toString()
            var parol2 = enterpassword.text.toString()
            val retrofit = Retrofit.Builder()
                .baseUrl("http://strukov-artemii.online:8081/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
               .build()
            retrofit.create(API::class.java).getPosts(REQUETS_MODEL(pochta, parol, login))
                .enqueue(object: Callback<String> {
                    override fun onResponse(call: Call<String>, response: Response<String>) {
                        if(response.isSuccessful){
                            Toast.makeText(this@RegAct,"You're successfully registered",Toast.LENGTH_LONG).show()
                            startActivity(Intent(this@RegAct,AuthAct::class.java))
                        }
                    }

                    override fun onFailure(call: Call<String>, t: Throwable) {
                        Toast.makeText(this@RegAct,t.message,Toast.LENGTH_LONG).show()
                        finish()
                    }
                })
        }
    }
}