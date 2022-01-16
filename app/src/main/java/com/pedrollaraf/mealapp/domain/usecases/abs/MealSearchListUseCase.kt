package com.pedrollaraf.mealapp.domain.usecases.abs

import com.pedrollaraf.mealapp.domain.models.Meal

interface MealSearchListUseCase {
    suspend fun invoke(query : String): List<Meal>
}