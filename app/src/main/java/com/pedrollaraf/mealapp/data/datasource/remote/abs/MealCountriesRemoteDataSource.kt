package com.pedrollaraf.mealapp.data.datasource.remote.abs

import com.pedrollaraf.mealapp.data.datasource.remote.modelresponse.MealCountryResponse

interface MealCountriesRemoteDataSource {
    suspend fun getCountries() : List<MealCountryResponse>
}