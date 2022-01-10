package com.pedrollaraf.mealapp.data.datasource.remote.abs

import com.pedrollaraf.mealapp.data.datasource.remote.modelresponse.MealByCategoryResponse

interface MealByCategoryRemoteDataSource {
    suspend fun getMealCategories() : List<MealByCategoryResponse>
}