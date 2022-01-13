package com.pedrollaraf.mealapp.data.datasource.remote.abs

import com.pedrollaraf.mealapp.data.datasource.remote.modelresponse.MealsFromCategoryOrCountryResponse

interface MealListFromCountryRemoteDataSource {
    suspend fun getMealsFromCountry(countryName : String): List<MealsFromCategoryOrCountryResponse>
}