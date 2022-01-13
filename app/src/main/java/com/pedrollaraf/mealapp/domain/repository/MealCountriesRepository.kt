package com.pedrollaraf.mealapp.domain.repository

import com.pedrollaraf.mealapp.domain.models.MealCountry

interface MealCountriesRepository {
    suspend fun getCountries(): List<MealCountry>
}