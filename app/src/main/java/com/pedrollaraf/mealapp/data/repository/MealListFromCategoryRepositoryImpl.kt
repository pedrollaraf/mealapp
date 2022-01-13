package com.pedrollaraf.mealapp.data.repository

import com.pedrollaraf.mealapp.data.datasource.mappers.toListMealFromCategoryOrCountryDomainModel
import com.pedrollaraf.mealapp.data.datasource.remote.abs.MealListFromCategoryRemoteDataSource
import com.pedrollaraf.mealapp.data.datasource.remote.modelresponse.MealsFromCategoryOrCountryResponse
import com.pedrollaraf.mealapp.domain.models.MealFromCategoryOrCountry
import com.pedrollaraf.mealapp.domain.repository.MealListFromCategoryRepository

class MealListFromCategoryRepositoryImpl(
    private val mealListFromCategoryRemoteDataSource : MealListFromCategoryRemoteDataSource
    ) : MealListFromCategoryRepository {
    override suspend fun getMealsFromCategory(categoryName : String): List<MealFromCategoryOrCountry> {
        return mealListFromCategoryRemoteDataSource.getMealsFromCategory(categoryName).toListMealFromCategoryOrCountryDomainModel()
    }
}