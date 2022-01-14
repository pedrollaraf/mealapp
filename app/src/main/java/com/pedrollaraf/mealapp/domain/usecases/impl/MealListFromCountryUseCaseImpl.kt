package com.pedrollaraf.mealapp.domain.usecases.impl

import com.pedrollaraf.mealapp.domain.models.MealFromCategoryOrCountry
import com.pedrollaraf.mealapp.domain.repository.MealListFromCountryRepository
import com.pedrollaraf.mealapp.domain.usecases.abs.MealListFromCountryUseCase

class MealListFromCountryUseCaseImpl(
    private val mealListFromCountryRepository: MealListFromCountryRepository
): MealListFromCountryUseCase {
    override suspend fun invoke(countryName: String): List<MealFromCategoryOrCountry> {
        return mealListFromCountryRepository.getMealsFromCountry(countryName)
    }
}