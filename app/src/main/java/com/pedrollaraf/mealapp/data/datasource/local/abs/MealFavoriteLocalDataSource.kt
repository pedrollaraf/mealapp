package com.pedrollaraf.mealapp.data.datasource.local.abs

import com.pedrollaraf.mealapp.data.datasource.local.entity.MealFavoriteEntity

interface MealFavoriteLocalDataSource {
    suspend fun addMealOnFavoriteList(meal: MealFavoriteEntity): String
    suspend fun removeMealOnFavoriteList(meal: MealFavoriteEntity): String
    suspend fun getListMealFavorite() : List<MealFavoriteEntity>

}