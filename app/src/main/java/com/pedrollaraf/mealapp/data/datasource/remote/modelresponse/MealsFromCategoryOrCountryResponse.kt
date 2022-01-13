package com.pedrollaraf.mealapp.data.datasource.remote.modelresponse

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MealsFromCategoryOrCountryResponse(
    var idMeal: String = "",
    var strMeal: String = "",
    var strMealThumb: String = ""
) : Parcelable