package com.pedrollaraf.mealapp.common.di

import com.pedrollaraf.mealapp.domain.di.getMealSearchDomainModules
import com.pedrollaraf.mealapp.domain.di.getMealCategoriesDomainModules
import com.pedrollaraf.mealapp.domain.di.getMealCountriesDomainModules
import com.pedrollaraf.mealapp.domain.di.getMealFavoriteDomainModules


class DIDomainModules {
    fun getDomainModules() = listOf (
        getMealCategoriesDomainModules(),
        getMealCountriesDomainModules(),
        getMealSearchDomainModules(),
        getMealFavoriteDomainModules()
    )
}