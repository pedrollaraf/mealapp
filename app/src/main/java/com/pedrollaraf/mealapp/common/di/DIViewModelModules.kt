package com.pedrollaraf.mealapp.common.di

import com.pedrollaraf.mealapp.presentation.di.getMealByCategoryViewModelModules
import com.pedrollaraf.mealapp.presentation.di.getMealByCountryViewModelModules

class DIViewModelModules {
    fun getViewModelModules() = listOf (
        getMealByCategoryViewModelModules(),
        getMealByCountryViewModelModules()
    )
}
