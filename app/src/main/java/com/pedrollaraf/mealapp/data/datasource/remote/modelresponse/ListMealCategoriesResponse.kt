package com.pedrollaraf.mealapp.data.datasource.remote.modelresponse

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ListMealCategoriesResponse(
    val categories : List<MealCategoryResponse>
):Parcelable