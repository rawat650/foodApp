package com.Repository

import com.network.ApiService

class RandomFoodRepository(val apiService: ApiService) {
    suspend fun getRandom() = apiService.getRandomfood()
}