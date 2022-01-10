package com.pedrollaraf.mealapp.common.di

import com.pedrollaraf.mealapp.data.datasource.remote.di.getMealByCountryDataSourceModules
import com.pedrollaraf.mealapp.data.datasource.remote.di.getMealByCategoryDataSourceModules
import com.pedrollaraf.mealapp.data.di.getMealByCountryDataModules
import com.pedrollaraf.mealapp.data.service.di.getMealByCategoryServiceModules
import com.pedrollaraf.mealapp.data.di.getMealByCategoryDataModules
import com.pedrollaraf.mealapp.data.service.di.getMealByCountryServiceModules


class DIDataModule {
    fun getRepositoriesModules() = listOf (
        getMealByCategoryDataModules(),
        getMealByCountryDataModules()
    )

    fun getDataSourceModules() = listOf (
        getMealByCategoryDataSourceModules(),
        getMealByCountryDataSourceModules()
    )

    fun getServicesModules() = listOf (
        getMealByCategoryServiceModules(),
        getMealByCountryServiceModules()
    )
}