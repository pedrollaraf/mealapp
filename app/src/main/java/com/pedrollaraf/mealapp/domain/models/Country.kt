package com.pedrollaraf.mealapp.domain.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Country(
    val strArea : String = ""
): Parcelable