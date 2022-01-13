package com.pedrollaraf.mealapp.domain.usecases.abs

import com.pedrollaraf.mealapp.domain.models.MealCountry

interface GetMealCountriesUseCase {
    suspend fun invoke() : List<MealCountry>
}