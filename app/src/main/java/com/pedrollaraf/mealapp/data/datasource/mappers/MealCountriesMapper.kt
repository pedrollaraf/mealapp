package com.pedrollaraf.mealapp.data.datasource.mappers

import com.pedrollaraf.mealapp.data.datasource.remote.modelresponse.MealCountryResponse
import com.pedrollaraf.mealapp.domain.models.MealCountry

fun List<MealCountryResponse>.toListMealCountriesDomainModel() = mapNotNull {
    try {
        it.toMealCountryDomainModel()
    } catch (e: Exception) {
        null
    }
}

internal fun MealCountryResponse.toMealCountryDomainModel() = MealCountry(
    strArea = strArea
)