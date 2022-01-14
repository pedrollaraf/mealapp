package com.pedrollaraf.mealapp.data.datasource.remote.abs

import com.pedrollaraf.mealapp.data.datasource.remote.modelresponse.MealSearchResponse

interface MealSearchListRemoteDataSource {
    suspend fun getHomeSearchMeals(query : String) : List<MealSearchResponse>
}