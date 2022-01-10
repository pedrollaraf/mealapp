package com.pedrollaraf.mealapp.common.di

import com.pedrollaraf.mealapp.presentation.di.getMealCategoriesViewModelModules
import com.pedrollaraf.mealapp.presentation.di.getMealCountriesViewModelModules

class DIViewModelModules {
    fun getViewModelModules() = listOf (
        getMealCategoriesViewModelModules(),
        getMealCountriesViewModelModules()
    )
}
