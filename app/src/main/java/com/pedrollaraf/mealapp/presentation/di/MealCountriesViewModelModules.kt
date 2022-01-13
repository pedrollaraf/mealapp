package com.pedrollaraf.mealapp.presentation.di

import com.pedrollaraf.mealapp.presentation.viewmodels.MealCountriesViewModel
import com.pedrollaraf.mealapp.presentation.viewmodels.MealListFromCountryViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun getMealCountriesViewModelModules() = module {
    viewModel { MealCountriesViewModel(
        getMealCountriesUseCase = get()
    ) }

    viewModel { MealListFromCountryViewModel(
        getMealListFromCountryUseCase = get()
    ) }
}