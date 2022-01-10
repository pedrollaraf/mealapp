package com.pedrollaraf.mealapp.presentation.di

import com.pedrollaraf.mealapp.presentation.viewmodels.MealByCountryViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun getMealByCountryViewModelModules() = module {
    viewModel { MealByCountryViewModel(get()) }
}