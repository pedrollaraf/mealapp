package com.pedrollaraf.mealapp.data.datasource.remote.modelresponse

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ListMealCountryResponse(
    val meals : List<MealCountryResponse>
): Parcelable