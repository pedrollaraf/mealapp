package com.pedrollaraf.mealapp.domain.usecases.impl

import com.pedrollaraf.mealapp.domain.models.MealFromCategoryOrCountry
import com.pedrollaraf.mealapp.domain.repository.MealListFromCountryRepository
import com.pedrollaraf.mealapp.domain.usecases.abs.GetMealListFromCountryUseCase

class GetMealListFromCountryUseCaseImpl(
    private val mealListFromCountryRepository: MealListFromCountryRepository
): GetMealListFromCountryUseCase {
    override suspend fun invoke(countryName: String): List<MealFromCategoryOrCountry> {
        return mealListFromCountryRepository.getMealsFromCountry(countryName)
    }
}