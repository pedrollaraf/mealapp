package com.pedrollaraf.mealapp.domain.di

import com.pedrollaraf.mealapp.domain.usecases.abs.GetCountriesUseCase
import com.pedrollaraf.mealapp.domain.usecases.impl.GetCountriesUseCaseImpl
import org.koin.dsl.module

fun getCountriesDomainModules() = module {
    factory<GetCountriesUseCase> { GetCountriesUseCaseImpl(get()) }
}