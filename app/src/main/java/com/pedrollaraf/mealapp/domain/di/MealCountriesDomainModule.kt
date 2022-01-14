package com.pedrollaraf.mealapp.domain.di

import com.pedrollaraf.mealapp.domain.usecases.abs.MealCountriesUseCase
import com.pedrollaraf.mealapp.domain.usecases.abs.MealListFromCountryUseCase
import com.pedrollaraf.mealapp.domain.usecases.impl.MealCountriesUseCaseImpl
import com.pedrollaraf.mealapp.domain.usecases.impl.MealListFromCountryUseCaseImpl
import org.koin.dsl.module

fun getMealCountriesDomainModules() = module {
    factory<MealCountriesUseCase> { MealCountriesUseCaseImpl(
        getMealCountriesRepository = get()
    )}

    factory<MealListFromCountryUseCase> { MealListFromCountryUseCaseImpl(
        mealListFromCountryRepository = get()
    ) }
}