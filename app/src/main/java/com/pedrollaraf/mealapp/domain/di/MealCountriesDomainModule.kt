package com.pedrollaraf.mealapp.domain.di

import com.pedrollaraf.mealapp.domain.usecases.abs.GetMealCountriesUseCase
import com.pedrollaraf.mealapp.domain.usecases.abs.GetMealListFromCountryUseCase
import com.pedrollaraf.mealapp.domain.usecases.impl.GetMealCountriesUseCaseImpl
import com.pedrollaraf.mealapp.domain.usecases.impl.GetMealListFromCountryUseCaseImpl
import org.koin.dsl.module

fun getMealCountriesDomainModules() = module {
    factory<GetMealCountriesUseCase> { GetMealCountriesUseCaseImpl(
        getMealCountriesRepository = get()
    )}

    factory<GetMealListFromCountryUseCase> { GetMealListFromCountryUseCaseImpl(
        mealListFromCountryRepository = get()
    ) }
}