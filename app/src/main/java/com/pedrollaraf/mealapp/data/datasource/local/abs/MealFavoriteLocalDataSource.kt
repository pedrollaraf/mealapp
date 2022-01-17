package com.pedrollaraf.mealapp.data.datasource.local.abs

import com.pedrollaraf.mealapp.data.datasource.local.entity.MealFavoriteEntity

interface MealFavoriteLocalDataSource {
    suspend fun addMealOnFavoriteList(meal: MealFavoriteEntity): Boolean
}