package com.pedrollaraf.mealapp.presentation.di

import com.pedrollaraf.mealapp.presentation.viewmodels.MealDetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun getMealDetailsViewModelModules() = module {
    viewModel {
        MealDetailsViewModel(
            mealSearchUseCase = get(),
            mealFavoriteDelegationInterface = get()
        )
    }
}