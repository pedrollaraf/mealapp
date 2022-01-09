package com.pedrollaraf.mealapp.common.di

import com.pedrollaraf.mealapp.presentation.di.getMealViewModelModules

class ViewModelModules {
    fun get() = listOf (
        getMealViewModelModules()
    )
}
