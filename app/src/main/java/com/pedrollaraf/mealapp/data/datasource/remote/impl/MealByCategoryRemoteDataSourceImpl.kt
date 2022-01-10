package com.pedrollaraf.mealapp.data.datasource.remote.impl

import com.pedrollaraf.mealapp.data.datasource.remote.abs.MealByCategoryRemoteDataSource
import com.pedrollaraf.mealapp.data.datasource.remote.modelresponse.MealByCategoryResponse
import com.pedrollaraf.mealapp.data.service.abs.MealByCategoryApi

class MealByCategoryRemoteDataSourceImpl(
    private val serviceMealByCategory: MealByCategoryApi
) : MealByCategoryRemoteDataSource {

    override suspend fun getMealCategories(): List<MealByCategoryResponse> {
        return try {
            val result = serviceMealByCategory.getMealCategories()
            if(result.categories.isNotEmpty()){
                result.categories
            }else{
                listOf()
            }
        } catch (e: Exception) {
            listOf()
        }
    }
}