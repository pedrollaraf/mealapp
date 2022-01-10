package com.pedrollaraf.mealapp.presentation.di

import com.pedrollaraf.mealapp.presentation.viewmodels.MealByCategoryViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun getMealByCategoryViewModelModules() = module {
    viewModel { MealByCategoryViewModel(get()) }
}