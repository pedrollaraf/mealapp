package com.pedrollaraf.mealapp.domain.usecases.impl

import com.pedrollaraf.mealapp.domain.models.MealCountry
import com.pedrollaraf.mealapp.domain.repository.MealCountriesRepository
import com.pedrollaraf.mealapp.domain.usecases.abs.GetMealCountriesUseCase

class GetMealCountriesUseCaseImpl(
    private val getMealCountriesRepository: MealCountriesRepository
) : GetMealCountriesUseCase {
    override suspend fun invoke(): List<MealCountry> {
        return getMealCountriesRepository.getCountries()
    }
}