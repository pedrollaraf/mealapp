package com.pedrollaraf.mealapp.domain.repository

import com.pedrollaraf.mealapp.domain.models.MealCategory

interface MealCategoriesRepository {
    suspend fun getMealCategories() : List<MealCategory>
}