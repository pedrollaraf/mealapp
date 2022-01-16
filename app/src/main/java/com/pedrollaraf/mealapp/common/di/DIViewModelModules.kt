package com.pedrollaraf.mealapp.common.di

import com.pedrollaraf.mealapp.presentation.di.*

class DIViewModelModules {
    fun getViewModelModules() = listOf (
        getMealCategoriesViewModelModules(),
        getMealCountriesViewModelModules(),
        getMealSearchViewModelModules(),
        getMealDetailsViewModelModules(),
        getMealFavoriteViewModelModules()
    )
}
