package com.pedrollaraf.mealapp.data.repository

import com.pedrollaraf.mealapp.data.datasource.mappers.toListMealFromCategoryOrCountryDomainModel
import com.pedrollaraf.mealapp.data.datasource.remote.abs.MealListFromCountryRemoteDataSource
import com.pedrollaraf.mealapp.domain.models.MealFromCategoryOrCountry
import com.pedrollaraf.mealapp.domain.repository.MealListFromCountryRepository

class MealListFromCountryRepositoryImpl(
    private val mealListFromCountryRemoteDataSource: MealListFromCountryRemoteDataSource
) : MealListFromCountryRepository {
    override suspend fun getMealsFromCountry(countryName: String): List<MealFromCategoryOrCountry> {
        return mealListFromCountryRemoteDataSource.getMealsFromCountry(countryName)
            .toListMealFromCategoryOrCountryDomainModel()
    }
}