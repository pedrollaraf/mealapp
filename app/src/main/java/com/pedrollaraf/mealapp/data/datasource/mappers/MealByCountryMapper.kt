package com.pedrollaraf.mealapp.data.datasource.mappers

import com.pedrollaraf.mealapp.data.datasource.remote.modelresponse.MealByCountryResponse
import com.pedrollaraf.mealapp.domain.models.MealByCountry

fun List<MealByCountryResponse>.toListMealByCountryDomainModel() = mapNotNull {
    try {
        it.toMealByCountryDomainModel()
    } catch (e: Exception) {
        null
    }
}

internal fun MealByCountryResponse.toMealByCountryDomainModel() = MealByCountry(
    strArea = strArea
)