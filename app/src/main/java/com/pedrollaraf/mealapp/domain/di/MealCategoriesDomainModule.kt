package com.pedrollaraf.mealapp.domain.di


import com.pedrollaraf.mealapp.domain.usecases.abs.GetMealCategoriesUseCase
import com.pedrollaraf.mealapp.domain.usecases.impl.GetMealCategoriesUseCaseImpl
import org.koin.dsl.module

fun getMealCategoriesDomainModules() = module {
    factory<GetMealCategoriesUseCase> { GetMealCategoriesUseCaseImpl(get()) }
}