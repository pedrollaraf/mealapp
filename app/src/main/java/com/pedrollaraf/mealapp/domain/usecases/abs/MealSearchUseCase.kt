package com.pedrollaraf.mealapp.domain.usecases.abs

import com.pedrollaraf.mealapp.domain.models.Meal

interface MealSearchUseCase {
    suspend fun invoke(query: String) : Meal
}