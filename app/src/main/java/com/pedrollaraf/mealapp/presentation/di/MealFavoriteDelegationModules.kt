package com.pedrollaraf.mealapp.presentation.di

import com.pedrollaraf.mealapp.presentation.ui.delegation.MealFavoriteDelegationManager
import com.pedrollaraf.mealapp.presentation.ui.delegation.MealFavoriteDelegationManagerImpl
import org.koin.dsl.module


fun getMealFavoriteDelegationModules() = module {
    factory<MealFavoriteDelegationManager> { MealFavoriteDelegationManagerImpl(
        mealFavoriteUseCase = get()
    )}
}