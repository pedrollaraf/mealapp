package com.pedrollaraf.mealapp.data.datasource.remote.abs

interface MealCategoriesRemoteDataSource {
    suspend fun getMealCategories()
}