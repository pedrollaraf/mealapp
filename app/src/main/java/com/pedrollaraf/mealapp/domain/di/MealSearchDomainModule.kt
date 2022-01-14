package com.pedrollaraf.mealapp.domain.di

import com.pedrollaraf.mealapp.domain.usecases.abs.MealSearchListUseCase
import com.pedrollaraf.mealapp.domain.usecases.impl.MealSearchListUseCaseImpl
import org.koin.dsl.module

fun getMealSearchDomainModules() = module {
    factory<MealSearchListUseCase> {
        MealSearchListUseCaseImpl(
            mealSearchListRepository = get()
        )
    }
}