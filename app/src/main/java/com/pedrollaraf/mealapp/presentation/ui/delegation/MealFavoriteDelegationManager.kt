package com.pedrollaraf.mealapp.presentation.ui.delegation

import com.pedrollaraf.mealapp.domain.models.Meal

interface MealFavoriteDelegationManager {
    suspend fun addMealOnFavoriteList(meal: Meal): String
    suspend fun removeMealOnFavoriteList(meal: Meal): String
    suspend fun getListMealFavorite(): List<Meal>
}