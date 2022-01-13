package com.pedrollaraf.mealapp.data.di

import com.pedrollaraf.mealapp.data.repository.MealCountriesRepositoryImpl
import com.pedrollaraf.mealapp.data.repository.MealListFromCountryRepositoryImpl
import com.pedrollaraf.mealapp.domain.repository.MealCountriesRepository
import com.pedrollaraf.mealapp.domain.repository.MealListFromCountryRepository
import org.koin.dsl.module

fun getMealCountriesDataModules() = module {
    factory<MealCountriesRepository> {
        MealCountriesRepositoryImpl(
            mealCountriesRemoteDataSource = get()
        )
    }

    factory<MealListFromCountryRepository> {
        MealListFromCountryRepositoryImpl(
            mealListFromCountryRemoteDataSource = get()
        )
    }
}