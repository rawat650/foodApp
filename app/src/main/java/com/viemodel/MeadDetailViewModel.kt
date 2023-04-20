package com.viemodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.Repository.MealDetailRepository
import com.model.RandomFood
import kotlinx.coroutines.launch

class MeadDetailViewModel(val mealDetailRepository: MealDetailRepository) :ViewModel(){
    val mealDetailLiveData = MutableLiveData<RandomFood>()
    fun getMealDetail(id:String){
        viewModelScope.launch {
            val response = mealDetailRepository.getMealDetail(id)
            mealDetailLiveData.postValue(response.body())

        }
    }
    fun mealDetail():LiveData<RandomFood>{
        return mealDetailLiveData
    }
}