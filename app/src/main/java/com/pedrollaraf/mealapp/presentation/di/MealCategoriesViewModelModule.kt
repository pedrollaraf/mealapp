package com.pedrollaraf.mealapp.presentation.di

import com.pedrollaraf.mealapp.presentation.viewmodels.MealCategoriesViewModel
import com.pedrollaraf.mealapp.presentation.viewmodels.MealListFromCategoryViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun getMealCategoriesViewModelModules() = module {
    viewModel { MealCategoriesViewModel(
        getMealCategoriesUseCase = get()
    ) }
    viewModel { MealListFromCategoryViewModel(
        getMealListFromCategoryUseCase = get()
    ) }
}