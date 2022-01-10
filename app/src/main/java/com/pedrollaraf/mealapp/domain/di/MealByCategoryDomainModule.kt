package com.pedrollaraf.mealapp.domain.di


import com.pedrollaraf.mealapp.domain.usecases.abs.GetMealByCategoryUseCase
import com.pedrollaraf.mealapp.domain.usecases.impl.GetMealByCategoryUseCaseImpl
import org.koin.dsl.module

fun getMealByCategoryDomainModules() = module {
    factory<GetMealByCategoryUseCase> { GetMealByCategoryUseCaseImpl(get()) }
}