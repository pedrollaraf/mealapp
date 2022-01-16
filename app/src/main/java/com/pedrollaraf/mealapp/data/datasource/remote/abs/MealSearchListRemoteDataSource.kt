package com.pedrollaraf.mealapp.data.datasource.remote.abs

import com.pedrollaraf.mealapp.data.datasource.remote.modelresponse.MealResponse

interface MealSearchListRemoteDataSource {
    suspend fun getHomeSearchMeals(query : String) : List<MealResponse>
}