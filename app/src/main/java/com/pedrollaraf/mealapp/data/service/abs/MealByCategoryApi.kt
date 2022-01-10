package com.pedrollaraf.mealapp.data.service.abs

import com.pedrollaraf.mealapp.data.datasource.remote.modelresponse.ListMealByCategoryResponse
import retrofit2.http.GET

interface MealByCategoryApi {

    @GET("categories.php")
    suspend fun getMealCategories(): ListMealByCategoryResponse
}