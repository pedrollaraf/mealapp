package com.pedrollaraf.mealapp.domain.usecases.impl

import com.pedrollaraf.mealapp.domain.models.MealByCountry
import com.pedrollaraf.mealapp.domain.repository.MealByCountryRepository
import com.pedrollaraf.mealapp.domain.usecases.abs.GetMealByCountryUseCase

class GetMealByCountryUseCaseImpl(private val getMealByCountryRepository: MealByCountryRepository) :
    GetMealByCountryUseCase {
    override suspend fun invoke(): List<MealByCountry> {
        return getMealByCountryRepository.getCountries()
    }
}