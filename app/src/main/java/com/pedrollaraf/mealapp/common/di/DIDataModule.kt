package com.pedrollaraf.mealapp.common.di

import com.pedrollaraf.mealapp.data.datasource.remote.di.getCountriesDataSourceModules
import com.pedrollaraf.mealapp.data.datasource.remote.di.getMealCategoriesDataSourceModules
import com.pedrollaraf.mealapp.data.di.getCountriesDataModules
import com.pedrollaraf.mealapp.data.service.di.getMealCategoriesServiceModules
import com.pedrollaraf.mealapp.data.di.getMealCategoriesDataModules
import com.pedrollaraf.mealapp.data.service.di.getCountriesServiceModules


class DIDataModule {
    fun getRepositoriesModules() = listOf (
        getMealCategoriesDataModules(),
        getCountriesDataModules()
    )

    fun getDataSourceModules() = listOf (
        getMealCategoriesDataSourceModules(),
        getCountriesDataSourceModules()
    )

    fun getServicesModules() = listOf (
        getMealCategoriesServiceModules(),
        getCountriesServiceModules()
    )
}