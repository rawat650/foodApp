package com.viemodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.Repository.RandomFoodRepository

class RandomFactory (val repository: RandomFoodRepository): ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return RandomViewModel(repository) as T
        }
    }
