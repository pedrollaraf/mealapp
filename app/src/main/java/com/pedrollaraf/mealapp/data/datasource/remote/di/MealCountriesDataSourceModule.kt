package com.pedrollaraf.mealapp.data.datasource.remote.di

import com.pedrollaraf.mealapp.data.datasource.remote.abs.MealCountriesRemoteDataSource
import com.pedrollaraf.mealapp.data.datasource.remote.abs.MealListFromCountryRemoteDataSource
import com.pedrollaraf.mealapp.data.datasource.remote.impl.MealCountriesRemoteDataSourceImpl
import com.pedrollaraf.mealapp.data.datasource.remote.impl.MealListFromCountryRemoteDataSourceImpl
import org.koin.dsl.module

fun getMealCountriesDataSourceModules() = module {
    factory<MealCountriesRemoteDataSource> { MealCountriesRemoteDataSourceImpl(
        serviceMealCountries = get()
    )}

    factory<MealListFromCountryRemoteDataSource> { MealListFromCountryRemoteDataSourceImpl(
        serviceMealListCountry = get()
    )}
}