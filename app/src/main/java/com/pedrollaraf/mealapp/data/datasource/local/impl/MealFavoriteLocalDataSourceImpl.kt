package com.pedrollaraf.mealapp.data.datasource.local.impl

import com.pedrollaraf.mealapp.common.keys.FavoriteKeys
import com.pedrollaraf.mealapp.data.datasource.local.abs.MealFavoriteLocalDataSource
import com.pedrollaraf.mealapp.data.datasource.local.commons.RoomLocalDataBase
import com.pedrollaraf.mealapp.data.datasource.local.entity.MealFavoriteEntity

class MealFavoriteLocalDataSourceImpl(
    private val roomLocalDataBase: RoomLocalDataBase
) : MealFavoriteLocalDataSource {
    override suspend fun addMealOnFavoriteList(meal: MealFavoriteEntity): String {
        return try {
            roomLocalDataBase.mealFavoriteDao().insert(meal)
            FavoriteKeys.FAVORITED.toString()
        } catch (ex: Exception) {
            FavoriteKeys.ERROR.toString()
        }
    }

    override suspend fun removeMealOnFavoriteList(meal: MealFavoriteEntity): String {
        return try {
            roomLocalDataBase.mealFavoriteDao().delete(meal)
            FavoriteKeys.UNFAVORITED.toString()
        } catch (ex: Exception) {
            FavoriteKeys.ERROR.toString()
        }
    }

    override suspend fun getListMealFavorite(): List<MealFavoriteEntity> {
        return try {
            return roomLocalDataBase.mealFavoriteDao().getAll()
        } catch (ex: Exception) {
            listOf()
        }
    }
}