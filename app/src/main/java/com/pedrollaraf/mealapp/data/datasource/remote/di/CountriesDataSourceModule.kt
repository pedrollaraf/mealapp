package com.pedrollaraf.mealapp.data.datasource.remote.di

import com.pedrollaraf.mealapp.data.datasource.remote.abs.CountryRemoteDataSource
import com.pedrollaraf.mealapp.data.datasource.remote.impl.CountryRemoteDataSourceImpl
import org.koin.dsl.module

fun getCountriesDataSourceModules() = module {
    factory<CountryRemoteDataSource> { CountryRemoteDataSourceImpl(get()) }
}