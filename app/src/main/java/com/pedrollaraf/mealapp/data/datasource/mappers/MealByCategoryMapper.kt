package com.pedrollaraf.mealapp.data.datasource.mappers

import com.pedrollaraf.mealapp.data.datasource.remote.modelresponse.MealByCategoryResponse
import com.pedrollaraf.mealapp.domain.models.MealByCategory

fun List<MealByCategoryResponse>.toListMealByCategoryDomainModel() = mapNotNull {
    try {
        it.toMealByCategoryDomainModel()
    } catch (e: Exception) {
        null
    }
}

internal fun MealByCategoryResponse.toMealByCategoryDomainModel() = MealByCategory(
    idCategory = idCategory,
    strCategory = strCategory,
    strCategoryThumb = strCategoryThumb,
    strCategoryDescription = strCategoryDescription
)