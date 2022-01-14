package com.pedrollaraf.mealapp.domain.usecases.impl

import com.pedrollaraf.mealapp.domain.models.MealCategory
import com.pedrollaraf.mealapp.domain.repository.MealCategoriesRepository
import com.pedrollaraf.mealapp.domain.usecases.abs.MealCategoriesUseCase

class MealCategoriesUseCaseImpl(
    private val getMealCategoriesRepository: MealCategoriesRepository
) : MealCategoriesUseCase {
    override suspend fun invoke(): List<MealCategory> {
        return getMealCategoriesRepository.getMealCategories()
    }
}