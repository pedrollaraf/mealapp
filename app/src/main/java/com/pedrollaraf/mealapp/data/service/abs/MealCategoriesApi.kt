package com.pedrollaraf.mealapp.data.service.abs

import com.pedrollaraf.mealapp.data.datasource.remote.modelresponse.MealListCategories
import retrofit2.http.GET

interface MealCategoriesApi {

    @GET("categories.php")
    suspend fun getMealCategories(): MealListCategories
}