package com.pedrollaraf.mealapp.data.datasource.remote.abs

import com.pedrollaraf.mealapp.data.datasource.remote.modelresponse.MealsFromCategoryOrCountryResponse

interface MealListFromCategoryRemoteDataSource {
    suspend fun getMealsFromCategory(categoryName : String): List<MealsFromCategoryOrCountryResponse>
}