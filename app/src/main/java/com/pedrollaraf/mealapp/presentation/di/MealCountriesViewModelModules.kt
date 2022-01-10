package com.pedrollaraf.mealapp.presentation.di

import com.pedrollaraf.mealapp.presentation.viewmodels.CountryViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun getMealCountriesViewModelModules() = module {
    viewModel { CountryViewModel(get()) }
}