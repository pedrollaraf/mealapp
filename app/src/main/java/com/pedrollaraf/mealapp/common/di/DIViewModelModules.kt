package com.pedrollaraf.mealapp.common.di

import com.pedrollaraf.mealapp.presentation.di.getMealSearchViewModelModules
import com.pedrollaraf.mealapp.presentation.di.getMealCategoriesViewModelModules
import com.pedrollaraf.mealapp.presentation.di.getMealCountriesViewModelModules
import com.pedrollaraf.mealapp.presentation.di.getMealDetailsViewModelModules

class DIViewModelModules {
    fun getViewModelModules() = listOf (
        getMealCategoriesViewModelModules(),
        getMealCountriesViewModelModules(),
        getMealSearchViewModelModules(),
        getMealDetailsViewModelModules()
    )
}
