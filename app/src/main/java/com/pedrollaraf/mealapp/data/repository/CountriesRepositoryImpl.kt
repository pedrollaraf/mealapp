package com.pedrollaraf.mealapp.data.repository

import com.pedrollaraf.mealapp.data.datasource.mappers.toListCountriesDomainModel
import com.pedrollaraf.mealapp.data.datasource.remote.abs.CountryRemoteDataSource
import com.pedrollaraf.mealapp.domain.models.Country
import com.pedrollaraf.mealapp.domain.repository.CountriesRepository

class CountriesRepositoryImpl(private val countryRemoteDataSource: CountryRemoteDataSource) : CountriesRepository {
    override suspend fun getCountries() : List<Country> {
        return countryRemoteDataSource.getCountries().toListCountriesDomainModel()
    }
}