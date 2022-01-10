package com.pedrollaraf.mealapp.data.datasource.remote.abs

import com.pedrollaraf.mealapp.data.datasource.remote.modelresponse.MealByCountryResponse

interface MealByCountryRemoteDataSource {
    suspend fun getCountries() : List<MealByCountryResponse>
}