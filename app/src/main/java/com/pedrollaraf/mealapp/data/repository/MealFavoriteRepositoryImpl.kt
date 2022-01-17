package com.pedrollaraf.mealapp.data.repository

import com.pedrollaraf.mealapp.data.datasource.local.abs.MealFavoriteLocalDataSource
import com.pedrollaraf.mealapp.data.datasource.mappers.toListMealFavoriteDomainModel
import com.pedrollaraf.mealapp.data.datasource.mappers.toMealFavoriteEntityDomainModel
import com.pedrollaraf.mealapp.domain.models.Meal
import com.pedrollaraf.mealapp.domain.repository.MealFavoriteRepository

class MealFavoriteRepositoryImpl(
    private val mealFavoriteLocalDataSource: MealFavoriteLocalDataSource
) : MealFavoriteRepository {
    override suspend fun addMealOnFavoriteList(meal: Meal) {
        mealFavoriteLocalDataSource.addMealOnFavoriteList(meal.toMealFavoriteEntityDomainModel())
    }
}