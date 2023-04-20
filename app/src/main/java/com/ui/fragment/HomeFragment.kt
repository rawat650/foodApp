package com.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.Repository.RandomFoodRepository
import com.bumptech.glide.Glide
import com.example.foodapp.R
import com.example.foodapp.databinding.FragmentHomeBinding
import com.model.Meals
import com.model.RandomFood
import com.network.ApiService
import com.viemodel.RandomFactory
import com.viemodel.RandomViewModel


class HomeFragment : Fragment() {
    lateinit var viewModel: RandomViewModel
    lateinit var binding: FragmentHomeBinding
    lateinit var randomMeals: Meals
    private val apiService = ApiService.getInstance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this, RandomFactory(RandomFoodRepository(apiService))).get(
            RandomViewModel::class.java)
        viewModel.randomFoodLive().observe(viewLifecycleOwner, Observer {
            Glide.with(this@HomeFragment).load(it.meals[0].strMealThumb).into(binding.imgRandomMeal)

            randomMeals = it.meals.get(0)

        })
        viewModel.getRandom()
        binding.imgRandomMeal.setOnClickListener {
            val intent = Intent(requireActivity(), RandomMealDetailActivity::class.java)
            intent.putExtra("pic", randomMeals.strMealThumb)
            intent.putExtra("id", randomMeals.idMeal)
            intent.putExtra("dishName", randomMeals.strMeal)
            intent.putExtra("youtube",randomMeals.strYoutube)
            startActivity(intent)

        }

    }




}




