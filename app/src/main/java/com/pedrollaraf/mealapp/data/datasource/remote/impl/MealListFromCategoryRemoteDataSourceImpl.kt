package com.pedrollaraf.mealapp.data.datasource.remote.impl

import com.pedrollaraf.mealapp.data.datasource.remote.abs.MealListFromCategoryRemoteDataSource
import com.pedrollaraf.mealapp.data.datasource.remote.modelresponse.MealsFromCategoryOrCountryResponse
import com.pedrollaraf.mealapp.data.service.abs.MealListCategoryService

class MealListFromCategoryRemoteDataSourceImpl(
    private val serviceMealListCategory : MealListCategoryService
) : MealListFromCategoryRemoteDataSource {
    override suspend fun getMealsFromCategory(categoryName : String): List<MealsFromCategoryOrCountryResponse> {
        return try {
            val result = serviceMealListCategory.getMealsFromCategory(categoryName)
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