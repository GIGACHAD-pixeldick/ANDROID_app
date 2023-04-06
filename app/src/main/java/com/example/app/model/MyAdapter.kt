package com.example.app.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.app.R
import kotlinx.android.synthetic.main.one_plant.view.*

class MyAdapter(private var plants: List<InfPlant>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.one_plant,parent,false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.title.text=plants[position].title
        holder.itemView.description.text=plants[position].description
        holder.itemView.price.text=plants[position].price.toString()
    }

    override fun getItemCount(): Int {
        return plants.size
    }

}
