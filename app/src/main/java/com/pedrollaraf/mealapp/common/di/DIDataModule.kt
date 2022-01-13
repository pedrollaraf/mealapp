package com.pedrollaraf.mealapp.common.di

import com.pedrollaraf.mealapp.data.datasource.remote.di.getMealCountriesDataSourceModules
import com.pedrollaraf.mealapp.data.datasource.remote.di.getMealCategoriesDataSourceModules
import com.pedrollaraf.mealapp.data.di.getMealCountriesDataModules
import com.pedrollaraf.mealapp.data.service.di.getMealCategoriesServiceModules
import com.pedrollaraf.mealapp.data.di.getMealCategoriesDataModules
import com.pedrollaraf.mealapp.data.service.di.getMealCountriesServiceModules


class DIDataModule {
    fun getRepositoriesModules() = listOf (
        getMealCategoriesDataModules(),
        getMealCountriesDataModules()
    )

    fun getDataSourceModules() = listOf (
        getMealCategoriesDataSourceModules(),
        getMealCountriesDataSourceModules()
    )

    fun getServicesModules() = listOf (
        getMealCategoriesServiceModules(),
        getMealCountriesServiceModules()
    )
}