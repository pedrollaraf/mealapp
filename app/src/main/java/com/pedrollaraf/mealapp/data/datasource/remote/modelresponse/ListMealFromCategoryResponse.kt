package com.pedrollaraf.mealapp.data.datasource.remote.modelresponse

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ListMealFromCategoryResponse(
    val meals: List<MealsFromCategoryOrCountryResponse>
) : Parcelable