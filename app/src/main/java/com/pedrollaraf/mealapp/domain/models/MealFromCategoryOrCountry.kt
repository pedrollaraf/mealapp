package com.pedrollaraf.mealapp.domain.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MealFromCategoryOrCountry(
    var idMeal: String = "",
    var strMeal: String = "",
    var strMealThumb: String = ""
) : Parcelable