package com.pedrollaraf.mealapp.data.datasource.local.impl

import com.pedrollaraf.mealapp.data.datasource.local.abs.MealFavoriteLocalDataSource
import com.pedrollaraf.mealapp.data.datasource.local.commons.RoomLocalDataBase
import com.pedrollaraf.mealapp.data.datasource.local.entity.MealFavoriteEntity

class MealFavoriteLocalDataSourceImpl(private val roomLocalDataBase: RoomLocalDataBase) : MealFavoriteLocalDataSource {
    override suspend fun addMealOnFavoriteList(meal: MealFavoriteEntity): Boolean {
        return try {
            roomLocalDataBase.mealFavoriteDao().insert(meal)
            true
        }catch (ex : Exception){
            false
        }
    }
}