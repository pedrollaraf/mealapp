package com.pedrollaraf.mealapp.data.datasource.remote.impl

import com.pedrollaraf.mealapp.data.datasource.remote.abs.MealByCountryRemoteDataSource
import com.pedrollaraf.mealapp.data.datasource.remote.modelresponse.MealByCountryResponse
import com.pedrollaraf.mealapp.data.service.abs.MealByCountryApi

class MealByCountryRemoteDataSourceImpl(private val serviceMealByCountry: MealByCountryApi) :
    MealByCountryRemoteDataSource {
    override suspend fun getCountries(): List<MealByCountryResponse> {
        return try {
            val result =
                serviceMealByCountry.getCountries(MealByCountryApi.API_QUERY_COUNTRIES_VALUE)
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