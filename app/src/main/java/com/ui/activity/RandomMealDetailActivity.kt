package com.ui.activity

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.Repository.MealDetailRepository
import com.bumptech.glide.Glide
import com.example.foodapp.databinding.ActivityRandomMealDetailBinding
import com.model.Meals
import com.network.ApiService
import com.viemodel.MeadDetailViewModel
import com.viemodel.MealDetailFactory

class RandomMealDetailActivity : AppCompatActivity() {
    val apiInterface = ApiService.getInstance()
    lateinit var binding: ActivityRandomMealDetailBinding
    lateinit var viewModel: MeadDetailViewModel
    lateinit var youtube:String
    private lateinit var id: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRandomMealDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setData()
        viewModel =
            ViewModelProvider(this, MealDetailFactory(MealDetailRepository(apiInterface))).get(
                MeadDetailViewModel::class.java)
        viewModel.mealDetail().observe(this, Observer {
            val meals = it.meals[0]
            binding.txtDescription.text = meals.strInstructions
            binding.txtCategory.text = "Category : " + meals.strCategory
            binding.txtArea.text = "Area : " + meals.strArea

        })
        viewModel.getMealDetail(id)
        binding.imgYoutube.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(youtube))
            startActivity(intent)
        }


    }

    fun setData() {
        val getIntent = intent
        val img = getIntent.getStringExtra("pic")
        val dishName = getIntent.getStringExtra("dishName")
        id = getIntent.getStringExtra("id") as String
        youtube = getIntent.getStringExtra("youtube")!!
        binding.txtDishName.text = dishName

        Log.d("name", dishName.toString())
        Glide.with(this).load(img).into(binding.imgDetail)

    }
}