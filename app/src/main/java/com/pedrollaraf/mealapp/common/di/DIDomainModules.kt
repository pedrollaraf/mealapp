package com.pedrollaraf.mealapp.common.di

import com.pedrollaraf.mealapp.domain.di.getMealByCategoryDomainModules
import com.pedrollaraf.mealapp.domain.di.getMealByCountryDomainModules


class DIDomainModules {
    fun getDomainModules() = listOf (
        getMealByCategoryDomainModules(),
        getMealByCountryDomainModules()
    )
}