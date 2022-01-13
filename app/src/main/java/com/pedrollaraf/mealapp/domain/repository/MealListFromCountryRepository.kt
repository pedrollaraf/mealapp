package com.pedrollaraf.mealapp.domain.repository

import com.pedrollaraf.mealapp.domain.models.MealFromCategoryOrCountry

interface MealListFromCountryRepository {
    suspend fun getMealsFromCountry(countryName : String): List<MealFromCategoryOrCountry>
}