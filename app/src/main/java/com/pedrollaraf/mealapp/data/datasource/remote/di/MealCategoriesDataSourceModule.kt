package com.pedrollaraf.mealapp.data.datasource.remote.di

import com.pedrollaraf.mealapp.data.datasource.remote.abs.MealCategoriesRemoteDataSource
import com.pedrollaraf.mealapp.data.datasource.remote.impl.MealCategoriesRemoteDataSourceImpl
import org.koin.dsl.module


fun getMealCategoriesDataSourceModules() = module {
    factory<MealCategoriesRemoteDataSource> { MealCategoriesRemoteDataSourceImpl(get()) }
}