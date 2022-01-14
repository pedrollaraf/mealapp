package com.pedrollaraf.mealapp.data.repository

import com.pedrollaraf.mealapp.data.datasource.mappers.toListMealSearchDomainModel
import com.pedrollaraf.mealapp.data.datasource.remote.abs.MealSearchListRemoteDataSource
import com.pedrollaraf.mealapp.domain.models.MealSearch
import com.pedrollaraf.mealapp.domain.repository.MealSearchListRepository

class MealSearchListRepositoryImpl(
    private val mealSearchListDataSource : MealSearchListRemoteDataSource
): MealSearchListRepository {
    override suspend fun getHomeSearchMeals(query : String): List<MealSearch> {
        return mealSearchListDataSource.getHomeSearchMeals(query).toListMealSearchDomainModel()
    }
}