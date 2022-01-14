package com.pedrollaraf.mealapp.data.service.abs

import com.pedrollaraf.mealapp.data.datasource.remote.modelresponse.ListMealSearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MealSearchListApi {

    companion object {
        private const val API_QUERY_SEARCH = "s"
    }

    @GET("search.php")
    suspend fun getHomeSearchMeals(
        @Query(API_QUERY_SEARCH) queryValue : String,
    ): ListMealSearchResponse
}