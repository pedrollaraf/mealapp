package com.pedrollaraf.mealapp.data.datasource.remote.impl

import com.pedrollaraf.mealapp.data.datasource.remote.abs.MealSearchListRemoteDataSource
import com.pedrollaraf.mealapp.data.datasource.remote.modelresponse.MealResponse
import com.pedrollaraf.mealapp.data.service.abs.MealSearchListApi

class MealSearchListRemoteDataSourceImpl(
    private val serviceMealSearchList : MealSearchListApi
) : MealSearchListRemoteDataSource {
    override suspend fun getHomeSearchMeals(query : String): List<MealResponse> {
        return try {
            val result = serviceMealSearchList.getHomeSearchMeals(query)
            if (result.meals.isNotEmpty()) {
                result.meals
            } else {
                listOf()
            }
        } catch (e: Exception) {
            listOf()
        }
    }
}