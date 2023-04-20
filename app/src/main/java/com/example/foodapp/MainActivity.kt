package com.example.foodapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.foodapp.databinding.ActivityMainBinding
import com.ui.fragment.CategoryFragment
import com.ui.fragment.FavouriteFragment
import com.ui.fragment.HomeFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btNavigation.setOnItemReselectedListener {
            when(it.itemId){
                R.id.homeFragment -> loadFragment(HomeFragment())
                R.id.categoriesFragment -> loadFragment(CategoryFragment())
                R.id.favouritesFragment -> loadFragment(FavouriteFragment())
        }
            true

        }


    }

    fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment)
            .addToBackStack(null).commit()
    }
}