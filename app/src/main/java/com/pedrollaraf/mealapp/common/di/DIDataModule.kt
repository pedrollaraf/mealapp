package com.pedrollaraf.mealapp.common.di

import com.pedrollaraf.mealapp.data.datasource.remote.di.getMealCountriesDataSourceModules
import com.pedrollaraf.mealapp.data.datasource.remote.di.getMealCategoriesDataSourceModules
import com.pedrollaraf.mealapp.data.datasource.remote.di.getMealSearchDataSourceModules
import com.pedrollaraf.mealapp.data.di.getMealSearchDataModules
import com.pedrollaraf.mealapp.data.di.getMealCountriesDataModules
import com.pedrollaraf.mealapp.data.service.di.getMealCategoriesServiceModules
import com.pedrollaraf.mealapp.data.di.getMealCategoriesDataModules
import com.pedrollaraf.mealapp.data.service.di.getMealCountriesServiceModules
import com.pedrollaraf.mealapp.data.service.di.getMealSearchServiceModules


class DIDataModule {
    fun getRepositoriesModules() = listOf (
        getMealCategoriesDataModules(),
        getMealCountriesDataModules(),
        getMealSearchDataModules()
    )

    fun getDataSourceModules() = listOf (
        getMealCategoriesDataSourceModules(),
        getMealCountriesDataSourceModules(),
        getMealSearchDataSourceModules()
    )

    fun getServicesModules() = listOf (
        getMealCategoriesServiceModules(),
        getMealCountriesServiceModules(),
        getMealSearchServiceModules()
    )
}