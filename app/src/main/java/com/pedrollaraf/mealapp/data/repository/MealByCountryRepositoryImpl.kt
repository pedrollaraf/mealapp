package com.pedrollaraf.mealapp.data.repository

import com.pedrollaraf.mealapp.data.datasource.mappers.toListMealByCountryDomainModel
import com.pedrollaraf.mealapp.data.datasource.remote.abs.MealByCountryRemoteDataSource
import com.pedrollaraf.mealapp.domain.models.MealByCountry
import com.pedrollaraf.mealapp.domain.repository.MealByCountryRepository

class MealByCountryRepositoryImpl(private val mealByCountryRemoteDataSource: MealByCountryRemoteDataSource) : MealByCountryRepository {
    override suspend fun getCountries() : List<MealByCountry> {
        return mealByCountryRemoteDataSource.getCountries().toListMealByCountryDomainModel()
    }
}