package com.pedrollaraf.mealapp.domain.usecases.impl

import com.pedrollaraf.mealapp.domain.models.MealFromCategoryOrCountry
import com.pedrollaraf.mealapp.domain.repository.MealListFromCategoryRepository
import com.pedrollaraf.mealapp.domain.usecases.abs.GetMealListFromCategoryUseCase

class GetMealListFromCategoryUseCaseImpl(
    private val mealListFromCategoryRepository: MealListFromCategoryRepository
) : GetMealListFromCategoryUseCase {
    override suspend fun invoke(categoryName : String): List<MealFromCategoryOrCountry> {
        return mealListFromCategoryRepository.getMealsFromCategory(categoryName)
    }
}