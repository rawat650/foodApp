package com.viemodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.Repository.MealDetailRepository


class MealDetailFactory(val repository: MealDetailRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MeadDetailViewModel(repository) as T
    }
}