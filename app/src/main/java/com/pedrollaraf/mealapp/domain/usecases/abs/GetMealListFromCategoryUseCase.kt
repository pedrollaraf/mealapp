package com.pedrollaraf.mealapp.domain.usecases.abs

import com.pedrollaraf.mealapp.domain.models.MealFromCategoryOrCountry

interface GetMealListFromCategoryUseCase {
    suspend fun invoke(categoryName : String): List<MealFromCategoryOrCountry>
}