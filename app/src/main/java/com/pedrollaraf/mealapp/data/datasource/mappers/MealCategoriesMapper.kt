package com.pedrollaraf.mealapp.data.datasource.mappers

import com.pedrollaraf.mealapp.data.datasource.remote.modelresponse.MealCategoryResponse
import com.pedrollaraf.mealapp.domain.models.MealCategory

fun List<MealCategoryResponse>.toListMealCategoriesDomainModel() = mapNotNull {
    try {
        it.toMealCategoryDomainModel()
    } catch (e: Exception) {
        null
    }
}

internal fun MealCategoryResponse.toMealCategoryDomainModel() = MealCategory(
    idCategory = idCategory,
    strCategory = strCategory,
    strCategoryThumb = strCategoryThumb,
    strCategoryDescription = strCategoryDescription
)