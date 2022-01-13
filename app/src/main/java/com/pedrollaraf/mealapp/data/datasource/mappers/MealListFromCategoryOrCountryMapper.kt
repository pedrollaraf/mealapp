package com.pedrollaraf.mealapp.data.datasource.mappers

import com.pedrollaraf.mealapp.data.datasource.remote.modelresponse.MealsFromCategoryOrCountryResponse
import com.pedrollaraf.mealapp.domain.models.MealFromCategoryOrCountry

fun List<MealsFromCategoryOrCountryResponse>.toListMealFromCategoryOrCountryDomainModel() =
    mapNotNull {
        try {
            it.toMealFromCategoryOrCountryDomainModel()
        } catch (e: Exception) {
            null
        }
    }

internal fun MealsFromCategoryOrCountryResponse.toMealFromCategoryOrCountryDomainModel() =
    MealFromCategoryOrCountry(
        idMeal = idMeal,
        strMeal = strMeal,
        strMealThumb = strMealThumb
    )