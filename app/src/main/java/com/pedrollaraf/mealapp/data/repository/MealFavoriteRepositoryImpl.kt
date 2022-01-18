package com.pedrollaraf.mealapp.data.repository

import com.pedrollaraf.mealapp.data.datasource.local.abs.MealFavoriteLocalDataSource
import com.pedrollaraf.mealapp.data.datasource.mappers.toListMealFavoriteDomainModel
import com.pedrollaraf.mealapp.data.datasource.mappers.toMealFavoriteEntityDomainModel
import com.pedrollaraf.mealapp.domain.models.Meal
import com.pedrollaraf.mealapp.domain.repository.MealFavoriteRepository

class MealFavoriteRepositoryImpl(
    private val mealFavoriteLocalDataSource: MealFavoriteLocalDataSource
) : MealFavoriteRepository {
    override suspend fun addMealOnFavoriteList(meal: Meal): String {
        return mealFavoriteLocalDataSource.addMealOnFavoriteList(
            meal.toMealFavoriteEntityDomainModel()
        )
    }

    override suspend fun removeMealOnFavoriteList(meal: Meal): String {
        return mealFavoriteLocalDataSource.removeMealOnFavoriteList(
            meal.toMealFavoriteEntityDomainModel()
        )
    }

    override suspend fun getListMealFavorite(): List<Meal> {
        return mealFavoriteLocalDataSource.getListMealFavorite().toListMealFavoriteDomainModel()
    }
}