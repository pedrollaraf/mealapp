package com.pedrollaraf.mealapp.data.datasource.remote.service.abs

import com.pedrollaraf.mealapp.data.datasource.remote.modelresponse.MealCategoryResponse
import com.pedrollaraf.mealapp.data.datasource.remote.modelresponse.MealListCategories
import retrofit2.http.GET
import retrofit2.Response

interface MealCategoriesApi {

    @GET("categories.php")
    suspend fun getMealCategories(): Response<MealListCategories>
}