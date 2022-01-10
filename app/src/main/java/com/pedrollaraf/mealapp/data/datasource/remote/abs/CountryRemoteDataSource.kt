package com.pedrollaraf.mealapp.data.datasource.remote.abs

import com.pedrollaraf.mealapp.data.datasource.remote.modelresponse.CountryResponse

interface CountryRemoteDataSource {
    suspend fun getCountries() : List<CountryResponse>
}