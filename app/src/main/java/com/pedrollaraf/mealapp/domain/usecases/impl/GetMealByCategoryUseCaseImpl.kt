package com.pedrollaraf.mealapp.domain.usecases.impl

import com.pedrollaraf.mealapp.domain.models.MealByCategory
import com.pedrollaraf.mealapp.domain.repository.MealByCategoryRepository
import com.pedrollaraf.mealapp.domain.usecases.abs.GetMealByCategoryUseCase

class GetMealByCategoryUseCaseImpl(
    private val getMealByCategoryRepository: MealByCategoryRepository
) : GetMealByCategoryUseCase {
    override suspend fun invoke(): List<MealByCategory> {
        return getMealByCategoryRepository.getMealCategories()
    }
}