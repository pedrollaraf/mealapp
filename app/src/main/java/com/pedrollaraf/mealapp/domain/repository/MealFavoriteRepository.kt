package com.pedrollaraf.mealapp.domain.repository

import com.pedrollaraf.mealapp.domain.models.Meal

interface MealFavoriteRepository {
    suspend fun addMealOnFavoriteList(meal: Meal)
}