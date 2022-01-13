package com.pedrollaraf.mealapp.data.datasource.remote.impl

import com.pedrollaraf.mealapp.data.datasource.remote.abs.MealCountriesRemoteDataSource
import com.pedrollaraf.mealapp.data.datasource.remote.modelresponse.MealCountryResponse
import com.pedrollaraf.mealapp.data.service.abs.MealCountriesApi

class MealCountriesRemoteDataSourceImpl(private val serviceMealCountries: MealCountriesApi) :
    MealCountriesRemoteDataSource {
    override suspend fun getCountries(): List<MealCountryResponse> {
        return try {
            val result =
                serviceMealCountries.getCountries(MealCountriesApi.API_QUERY_COUNTRIES_VALUE)
            if (result.meals.isNotEmpty()) {
                result.meals
            } else {
                listOf()
            }
        } catch (e: Exception) {
            listOf()
        }
    }
}