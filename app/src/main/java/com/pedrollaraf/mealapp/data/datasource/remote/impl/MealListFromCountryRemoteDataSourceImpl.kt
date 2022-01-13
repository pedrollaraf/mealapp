package com.pedrollaraf.mealapp.data.datasource.remote.impl

import com.pedrollaraf.mealapp.data.datasource.remote.abs.MealListFromCountryRemoteDataSource
import com.pedrollaraf.mealapp.data.datasource.remote.modelresponse.MealsFromCategoryOrCountryResponse
import com.pedrollaraf.mealapp.data.service.abs.MealListCountryService

class MealListFromCountryRemoteDataSourceImpl(
    private val serviceMealListCountry : MealListCountryService
) : MealListFromCountryRemoteDataSource {
    override suspend fun getMealsFromCountry(countryName : String): List<MealsFromCategoryOrCountryResponse> {
        return try {
            val result = serviceMealListCountry.getMealsFromCountry(countryName)
            if(result.meals.isNotEmpty()){
                result.meals
            }else{
                listOf()
            }
        } catch (e: Exception) {
            listOf()
        }
    }
}