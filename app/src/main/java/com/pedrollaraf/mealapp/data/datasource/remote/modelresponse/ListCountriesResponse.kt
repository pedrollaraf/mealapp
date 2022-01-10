package com.pedrollaraf.mealapp.data.datasource.remote.modelresponse

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ListCountriesResponse(
    val meals : List<CountryResponse>
): Parcelable