package com.pedrollaraf.mealapp.data.service.abs

import com.pedrollaraf.mealapp.data.datasource.remote.modelresponse.ListMealCountryResponse
import com.pedrollaraf.mealapp.data.datasource.remote.modelresponse.ListMealFromCategoryResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MealListCategoryService {

    companion object {
        private const val API_QUERY_MEALS_FROM_CATEGORY_FILTER = "c"
    }

    @GET("filter.php")
    suspend fun getMealsFromCategory(
        @Query(API_QUERY_MEALS_FROM_CATEGORY_FILTER) queryValue : String,
    ): ListMealFromCategoryResponse
}