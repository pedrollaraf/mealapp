package com.pedrollaraf.mealapp.domain.di

import com.pedrollaraf.mealapp.domain.usecases.abs.GetMealByCountryUseCase
import com.pedrollaraf.mealapp.domain.usecases.impl.GetMealByCountryUseCaseImpl
import org.koin.dsl.module

fun getMealByCountryDomainModules() = module {
    factory<GetMealByCountryUseCase> { GetMealByCountryUseCaseImpl(get()) }
}