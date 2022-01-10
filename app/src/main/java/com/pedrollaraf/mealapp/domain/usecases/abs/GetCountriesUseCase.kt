package com.pedrollaraf.mealapp.domain.usecases.abs

import com.pedrollaraf.mealapp.domain.models.Country

interface GetCountriesUseCase {
    suspend fun invoke() : List<Country>
}