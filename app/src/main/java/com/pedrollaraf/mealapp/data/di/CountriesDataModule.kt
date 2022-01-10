package com.pedrollaraf.mealapp.data.di

import com.pedrollaraf.mealapp.data.repository.CountriesRepositoryImpl
import com.pedrollaraf.mealapp.domain.repository.CountriesRepository
import org.koin.dsl.module

fun getCountriesDataModules() = module {
    factory<CountriesRepository> {
        CountriesRepositoryImpl(get())
    }
}