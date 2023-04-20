package com.network

import com.model.Meals
import com.model.PopularMeal
import com.model.RandomFood
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("random.php")
    suspend fun getRandomfood():Response<RandomFood>

    @GET("lookup.php?")
    suspend fun getMealDetail(@Query("i") id : String):  Response<RandomFood>

    @GET("filter.php?")
    suspend fun getPopularMeal(@Query("c") category:String):Response<PopularMeal>


    companion object {

        var retrofitService: ApiService? = null

        fun getInstance(): ApiService {

            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://www.themealdb.com/api/json/v1/1/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

                retrofitService = retrofit.create(ApiService::class.java)
            }
            return retrofitService!!
        }
    }
}