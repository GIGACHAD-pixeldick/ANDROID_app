package com.example.app.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app.R
import com.example.app.model.API_PLANTS
import com.example.app.model.InfPlant
import com.example.app.model.MyAdapter
import kotlinx.android.synthetic.main.activity_plants.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PlantsAct : AppCompatActivity() {
    var listInfPlant = arrayListOf<InfPlant>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plants)
        val retrofit = Retrofit.Builder()
            .baseUrl("http://strukov-artemii.online:8084")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(API_PLANTS:: class.java).getPlants().enqueue(object : Callback<List<InfPlant>> {
            override fun onResponse(
                call: Call<List<InfPlant>>,
                response: Response<List<InfPlant>>
            ) {
                if (response.isSuccessful){
                    for(I in response.body()!!){
                        listInfPlant.add(InfPlant(I.id, I.title, I.description, I.cover, I.price, I.room))
                    }
                    rec_view.adapter= MyAdapter(listInfPlant)
                    rec_view.layoutManager=LinearLayoutManager(this@PlantsAct)
                }
            }
            /**
             * Public Class Toast
             * @hide
             */
            override fun onFailure(call: Call<List<InfPlant>>, t: Throwable) {
                    Toast.makeText(this@PlantsAct,t.message,Toast.LENGTH_LONG).show()
            }
        })
    }
}
