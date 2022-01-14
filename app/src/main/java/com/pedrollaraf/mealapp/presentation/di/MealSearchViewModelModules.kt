package com.pedrollaraf.mealapp.presentation.di

import com.pedrollaraf.mealapp.presentation.viewmodels.MealSearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun getMealSearchViewModelModules() = module {
    viewModel {
        MealSearchViewModel(
            mealSearchListUseCase = get()
        )
    }
}