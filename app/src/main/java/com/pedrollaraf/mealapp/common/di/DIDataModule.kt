package com.pedrollaraf.mealapp.common.di

import com.pedrollaraf.mealapp.data.datasource.remote.di.getMealCategoriesDataSourceModules
import com.pedrollaraf.mealapp.data.service.di.getMealCategoriesServiceModules
import com.pedrollaraf.mealapp.data.di.getMealCategoriesDataModules


class DIDataModule {
    fun getRepositoriesModules() = listOf (
        getMealCategoriesDataModules()
    )

    fun getDataSourceModules() = listOf (
        getMealCategoriesDataSourceModules()
    )

    fun getServicesModules() = listOf (
        getMealCategoriesServiceModules()
    )
}