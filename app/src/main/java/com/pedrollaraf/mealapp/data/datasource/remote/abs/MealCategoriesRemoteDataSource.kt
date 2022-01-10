package com.pedrollaraf.mealapp.data.datasource.remote.abs

import com.pedrollaraf.mealapp.data.datasource.remote.modelresponse.MealCategoryResponse

interface MealCategoriesRemoteDataSource {
    suspend fun getMealCategories() : List<MealCategoryResponse>
}