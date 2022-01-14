package com.pedrollaraf.mealapp.domain.usecases.abs

import com.pedrollaraf.mealapp.domain.models.MealSearch

interface MealSearchUseCase {
    suspend fun invoke(query: String) : MealSearch
}