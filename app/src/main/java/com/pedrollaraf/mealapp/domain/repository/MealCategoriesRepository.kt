package com.pedrollaraf.mealapp.domain.repository

interface MealCategoriesRepository {
    suspend fun getMealCategories()
}