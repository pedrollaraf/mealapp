package com.pedrollaraf.mealapp.data.di

import com.pedrollaraf.mealapp.data.repository.MealByCountryRepositoryImpl
import com.pedrollaraf.mealapp.domain.repository.MealByCountryRepository
import org.koin.dsl.module

fun getMealByCountryDataModules() = module {
    factory<MealByCountryRepository> {
        MealByCountryRepositoryImpl(get())
    }
}