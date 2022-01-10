package com.pedrollaraf.mealapp.domain.repository

import com.pedrollaraf.mealapp.domain.models.MealByCountry

interface MealByCountryRepository {
    suspend fun getCountries(): List<MealByCountry>
}