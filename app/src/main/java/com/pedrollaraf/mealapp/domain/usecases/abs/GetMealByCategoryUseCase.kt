package com.pedrollaraf.mealapp.domain.usecases.abs

import com.pedrollaraf.mealapp.domain.models.MealByCategory

interface GetMealByCategoryUseCase {
    suspend fun invoke() : List<MealByCategory>
}