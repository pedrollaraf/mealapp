package com.pedrollaraf.mealapp.data.datasource.remote.modelresponse

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MealByCategoryResponse(
    val idCategory : String = "",
    val strCategory : String = "",
    val strCategoryThumb : String = "",
    val strCategoryDescription : String = ""
): Parcelable