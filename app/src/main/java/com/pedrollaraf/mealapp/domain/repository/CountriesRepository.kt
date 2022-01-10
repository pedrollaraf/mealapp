package com.pedrollaraf.mealapp.domain.repository

import com.pedrollaraf.mealapp.domain.models.Country

interface CountriesRepository {
    suspend fun getCountries(): List<Country>
}