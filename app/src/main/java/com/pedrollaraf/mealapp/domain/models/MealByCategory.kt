package com.pedrollaraf.mealapp.domain.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MealByCategory(
    val idCategory : String = "",
    val strCategory : String = "",
    val strCategoryThumb : String = "",
    val strCategoryDescription : String = ""
): Parcelable