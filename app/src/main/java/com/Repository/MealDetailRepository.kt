package com.Repository

import com.network.ApiService

class MealDetailRepository(val apiService: ApiService) {
    suspend fun getMealDetail (id:String) = apiService.getMealDetail(id)
}