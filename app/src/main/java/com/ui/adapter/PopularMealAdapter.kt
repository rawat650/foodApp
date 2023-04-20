package com.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.foodapp.databinding.PopularItemsBinding
import com.model.PopularMeal

class PopularMealAdapter(val list : List<PopularMeal>,val context: Context):RecyclerView.Adapter<PopularMealAdapter.PopularViewHolder>() {
    class PopularViewHolder(binding: PopularItemsBinding):RecyclerView.ViewHolder(binding.root){

val imgPopular = binding.imgPopular
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        val binding = PopularItemsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PopularViewHolder(binding)

    }

    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
       val data = list[position]
    Glide.with(context).load(data.meals.get(0).strMealThumb).into(holder.imgPopular)    }

    override fun getItemCount(): Int {
  return list.size
    }

}