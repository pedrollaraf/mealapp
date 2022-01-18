package com.pedrollaraf.mealapp.domain.repository

import com.pedrollaraf.mealapp.domain.models.Meal

interface MealFavoriteRepository {
    suspend fun addMealOnFavoriteList(meal: Meal): String
    suspend fun removeMealOnFavoriteList(meal: Meal): String
    suspend fun getListMealFavorite() : List<Meal>
}