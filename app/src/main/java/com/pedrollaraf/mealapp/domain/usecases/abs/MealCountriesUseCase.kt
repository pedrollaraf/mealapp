package com.pedrollaraf.mealapp.domain.usecases.abs

import com.pedrollaraf.mealapp.domain.models.MealCountry

interface MealCountriesUseCase {
    suspend fun invoke() : List<MealCountry>
}