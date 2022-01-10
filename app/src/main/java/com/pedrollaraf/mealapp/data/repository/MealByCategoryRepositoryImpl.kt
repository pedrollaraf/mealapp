package com.pedrollaraf.mealapp.data.repository

import com.pedrollaraf.mealapp.data.datasource.mappers.toListMealByCategoryDomainModel
import com.pedrollaraf.mealapp.data.datasource.remote.abs.MealByCategoryRemoteDataSource
import com.pedrollaraf.mealapp.domain.models.MealByCategory
import com.pedrollaraf.mealapp.domain.repository.MealByCategoryRepository

class MealByCategoryRepositoryImpl(
    private val mealByCategoryRemoteDataSource: MealByCategoryRemoteDataSource
) : MealByCategoryRepository {
    override suspend fun getMealCategories(): List<MealByCategory> {
        return mealByCategoryRemoteDataSource.getMealCategories().toListMealByCategoryDomainModel()
    }
}