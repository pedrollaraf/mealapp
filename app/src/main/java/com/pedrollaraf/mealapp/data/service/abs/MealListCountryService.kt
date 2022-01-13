package com.pedrollaraf.mealapp.data.service.abs

import com.pedrollaraf.mealapp.data.datasource.remote.modelresponse.ListMealFromCategoryResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MealListCountryService {

    companion object {
        private const val API_QUERY_MEALS_FROM_COUNTRY_FILTER = "a"
    }

    @GET("filter.php")
    suspend fun getMealsFromCountry(
        @Query(API_QUERY_MEALS_FROM_COUNTRY_FILTER) queryValue : String,
    ): ListMealFromCategoryResponse
}