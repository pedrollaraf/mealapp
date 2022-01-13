package com.pedrollaraf.mealapp.common.di

import com.pedrollaraf.mealapp.domain.di.getMealCategoriesDomainModules
import com.pedrollaraf.mealapp.domain.di.getMealCountriesDomainModules


class DIDomainModules {
    fun getDomainModules() = listOf (
        getMealCategoriesDomainModules(),
        getMealCountriesDomainModules()
    )
}