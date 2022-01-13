package com.pedrollaraf.mealapp.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MealCategory(
    val idCategory : String = "",
    val strCategory : String = "",
    val strCategoryThumb : String = "",
    val strCategoryDescription : String = ""
): Parcelable