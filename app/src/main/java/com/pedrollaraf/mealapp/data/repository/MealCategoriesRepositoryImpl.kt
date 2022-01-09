package com.pedrollaraf.mealapp.data.repository

import com.pedrollaraf.mealapp.data.datasource.remote.abs.MealCategoriesRemoteDataSource
import com.pedrollaraf.mealapp.domain.repository.MealCategoriesRepository

class MealCategoriesRepositoryImpl(
    private val mealCategoriesRemoteDataSource : MealCategoriesRemoteDataSource
) : MealCategoriesRepository {
    override suspend fun getMealCategories() {
        mealCategoriesRemoteDataSource.getMealCategories()
    }
}