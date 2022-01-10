package com.pedrollaraf.mealapp.data.datasource.remote.impl

import com.pedrollaraf.mealapp.data.datasource.remote.abs.CountryRemoteDataSource
import com.pedrollaraf.mealapp.data.datasource.remote.modelresponse.CountryResponse
import com.pedrollaraf.mealapp.data.service.abs.CountriesApi

class CountryRemoteDataSourceImpl(private val serviceCountries: CountriesApi) : CountryRemoteDataSource {
    override suspend fun getCountries() : List<CountryResponse> {
        return try {
            val result = serviceCountries.getCountries(CountriesApi.API_QUERY_COUNTRIES_VALUE)
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