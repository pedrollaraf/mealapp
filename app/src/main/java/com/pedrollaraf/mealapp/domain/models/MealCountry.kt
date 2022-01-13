package com.pedrollaraf.mealapp.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MealCountry(
    val strArea : String = ""
): Parcelable