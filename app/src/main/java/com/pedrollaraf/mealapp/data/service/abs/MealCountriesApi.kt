package com.pedrollaraf.mealapp.data.service.abs

import com.pedrollaraf.mealapp.data.datasource.remote.modelresponse.ListMealCountryResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MealCountriesApi {

    companion object {
        private const val API_QUERY_COUNTRIES = "a"
        const val API_QUERY_COUNTRIES_VALUE = "list"
    }

    @GET("list.php")
    suspend fun getCountries(
        @Query(API_QUERY_COUNTRIES) queryValue : String,
    ): ListMealCountryResponse
}