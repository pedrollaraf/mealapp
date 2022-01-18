package com.pedrollaraf.mealapp.presentation.di

import com.pedrollaraf.mealapp.presentation.viewmodels.MealFavoriteViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun getMealFavoriteViewModelModules() = module {
    viewModel {
        MealFavoriteViewModel(
            mealFavoriteDelegationManager = get()
        )
    }
}