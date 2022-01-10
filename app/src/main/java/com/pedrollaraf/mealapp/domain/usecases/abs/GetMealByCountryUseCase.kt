package com.pedrollaraf.mealapp.domain.usecases.abs

import com.pedrollaraf.mealapp.domain.models.MealByCountry

interface GetMealByCountryUseCase {
    suspend fun invoke() : List<MealByCountry>
}