package com.pedrollaraf.mealapp.common.di

import com.pedrollaraf.mealapp.presentation.di.getMealFavoriteDelegationModules


class DIDelegationModule {
    fun getDelegationModules() = listOf (
        getMealFavoriteDelegationModules()
    )
}