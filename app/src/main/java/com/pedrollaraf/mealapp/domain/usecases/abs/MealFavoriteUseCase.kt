package com.pedrollaraf.mealapp.domain.usecases.abs

import com.pedrollaraf.mealapp.domain.models.Meal

interface MealFavoriteUseCase {
    suspend fun addMealOnFavoriteList(meal: Meal): String
    suspend fun removeMealOnFavoriteList(meal: Meal): String
    suspend fun getListMealFavorite() : List<Meal>
}