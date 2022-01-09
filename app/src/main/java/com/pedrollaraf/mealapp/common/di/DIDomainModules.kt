package com.pedrollaraf.mealapp.common.di

import com.pedrollaraf.mealapp.domain.di.getMealCategoriesDomainModules


class DIDomainModules {
    fun getDomainModules() = listOf (
        getMealCategoriesDomainModules()
    )
}