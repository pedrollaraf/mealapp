package com.pedrollaraf.mealapp.common.di

import com.pedrollaraf.mealapp.presentation.di.getMealCategoriesViewModelModules

class DIViewModelModules {
    fun getViewModelModules() = listOf (
        getMealCategoriesViewModelModules()
    )
}
