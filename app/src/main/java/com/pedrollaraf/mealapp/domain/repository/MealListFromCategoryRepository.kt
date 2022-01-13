package com.pedrollaraf.mealapp.domain.repository

import com.pedrollaraf.mealapp.domain.models.MealFromCategoryOrCountry

interface MealListFromCategoryRepository {
    suspend fun getMealsFromCategory(categoryName : String): List<MealFromCategoryOrCountry>
}