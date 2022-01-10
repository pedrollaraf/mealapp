package com.pedrollaraf.mealapp.data.datasource.mappers

import com.pedrollaraf.mealapp.data.datasource.remote.modelresponse.CountryResponse
import com.pedrollaraf.mealapp.domain.models.Country

fun List<CountryResponse>.toListCountriesDomainModel() = mapNotNull {
    try {
        it.toCountryDomainModel()
    } catch (e: Exception) {
        null
    }
}

internal fun CountryResponse.toCountryDomainModel() = Country(
    strArea = strArea
)