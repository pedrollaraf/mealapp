package com.pedrollaraf.mealapp.domain.repository

import com.pedrollaraf.mealapp.domain.models.MealByCategory

interface MealByCategoryRepository {
    suspend fun getMealCategories() : List<MealByCategory>
}