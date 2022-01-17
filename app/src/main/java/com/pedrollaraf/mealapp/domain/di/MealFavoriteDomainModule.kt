package com.pedrollaraf.mealapp.domain.di

import com.pedrollaraf.mealapp.domain.usecases.abs.MealFavoriteUseCase
import com.pedrollaraf.mealapp.domain.usecases.impl.MealFavoriteUseCaseImpl
import org.koin.dsl.module

fun getMealFavoriteDomainModules() = module {
    factory<MealFavoriteUseCase> {
        MealFavoriteUseCaseImpl(
            mealFavoriteRepository = get()
        )
    }
}