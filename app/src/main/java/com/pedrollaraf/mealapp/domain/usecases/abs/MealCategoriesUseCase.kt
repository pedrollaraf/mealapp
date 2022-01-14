package com.pedrollaraf.mealapp.domain.usecases.abs

import com.pedrollaraf.mealapp.domain.models.MealCategory

interface MealCategoriesUseCase {
    suspend fun invoke() : List<MealCategory>
}