package com.pedrollaraf.mealapp.data.repository

import com.pedrollaraf.mealapp.data.datasource.mappers.toListMealCountriesDomainModel
import com.pedrollaraf.mealapp.data.datasource.remote.abs.MealCountriesRemoteDataSource
import com.pedrollaraf.mealapp.domain.models.MealCountry
import com.pedrollaraf.mealapp.domain.repository.MealCountriesRepository

class MealCountriesRepositoryImpl(
    private val mealCountriesRemoteDataSource: MealCountriesRemoteDataSource
    ) : MealCountriesRepository {
    override suspend fun getCountries(): List<MealCountry> {
        return mealCountriesRemoteDataSource.getCountries().toListMealCountriesDomainModel()
    }
}