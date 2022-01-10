package com.pedrollaraf.mealapp.data.datasource.remote.modelresponse

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MealListCategoriesResponse(
    val categories : List<MealCategoryResponse>
):Parcelable