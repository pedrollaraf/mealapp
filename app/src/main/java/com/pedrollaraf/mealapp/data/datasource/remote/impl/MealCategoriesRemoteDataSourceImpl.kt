package com.pedrollaraf.mealapp.data.datasource.remote.impl

import com.pedrollaraf.mealapp.data.datasource.remote.abs.MealCategoriesRemoteDataSource
import com.pedrollaraf.mealapp.data.datasource.remote.modelresponse.MealCategoryResponse
import com.pedrollaraf.mealapp.data.service.abs.MealCategoriesApi

class MealCategoriesRemoteDataSourceImpl(
    private val serviceMealCategories: MealCategoriesApi
) : MealCategoriesRemoteDataSource {

    override suspend fun getMealCategories(): List<MealCategoryResponse> {
        return try {
            val result = serviceMealCategories.getMealCategories()
            if (result.categories.isNotEmpty()) {
                result.categories
            } else {
                listOf()
            }
        } catch (e: Exception) {
            listOf()
        }
    }
}