package com.pedrollaraf.mealapp.data.repository

import com.pedrollaraf.mealapp.data.datasource.mappers.toListMealSearchDomainModel
import com.pedrollaraf.mealapp.data.datasource.remote.abs.MealSearchListRemoteDataSource
import com.pedrollaraf.mealapp.domain.models.Meal
import com.pedrollaraf.mealapp.domain.repository.MealSearchListRepository

class MealSearchListRepositoryImpl(
    private val mealSearchListDataSource : MealSearchListRemoteDataSource
): MealSearchListRepository {
    override suspend fun getSearchMeals(query : String): List<Meal> {
        return mealSearchListDataSource.getHomeSearchMeals(query).toListMealSearchDomainModel()
    }
}