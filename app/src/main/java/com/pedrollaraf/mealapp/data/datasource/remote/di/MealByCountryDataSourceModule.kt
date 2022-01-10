package com.pedrollaraf.mealapp.data.datasource.remote.di

import com.pedrollaraf.mealapp.data.datasource.remote.abs.MealByCountryRemoteDataSource
import com.pedrollaraf.mealapp.data.datasource.remote.impl.MealByCountryRemoteDataSourceImpl
import org.koin.dsl.module

fun getMealByCountryDataSourceModules() = module {
    factory<MealByCountryRemoteDataSource> { MealByCountryRemoteDataSourceImpl(get()) }
}