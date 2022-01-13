package com.pedrollaraf.mealapp.domain.usecases.abs

import com.pedrollaraf.mealapp.domain.models.MealFromCategoryOrCountry

interface GetMealListFromCountryUseCase {
    suspend fun invoke(countryName : String): List<MealFromCategoryOrCountry>
}