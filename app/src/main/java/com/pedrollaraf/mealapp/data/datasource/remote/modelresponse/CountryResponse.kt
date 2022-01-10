package com.pedrollaraf.mealapp.data.datasource.remote.modelresponse

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CountryResponse(
    val strArea : String = ""
): Parcelable