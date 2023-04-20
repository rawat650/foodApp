package com.viemodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.Repository.RandomFoodRepository
import com.model.Meals
import com.model.RandomFood
import kotlinx.coroutines.launch

class RandomViewModel(val randomFoodRepository: RandomFoodRepository) :ViewModel(){
    val randomFoodLiveData = MutableLiveData<RandomFood>()
    fun getRandom(){
        viewModelScope.launch {
            val response = randomFoodRepository.getRandom()
            randomFoodLiveData.postValue(response.body())


        }
    }
    fun randomFoodLive():LiveData<RandomFood>{
        return randomFoodLiveData
    }


}