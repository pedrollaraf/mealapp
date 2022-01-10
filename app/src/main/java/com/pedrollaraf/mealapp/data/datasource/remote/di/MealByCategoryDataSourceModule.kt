package com.pedrollaraf.mealapp.data.datasource.remote.di

import com.pedrollaraf.mealapp.data.datasource.remote.abs.MealByCategoryRemoteDataSource
import com.pedrollaraf.mealapp.data.datasource.remote.impl.MealByCategoryRemoteDataSourceImpl
import org.koin.dsl.module


fun getMealByCategoryDataSourceModules() = module {
    factory<MealByCategoryRemoteDataSource> { MealByCategoryRemoteDataSourceImpl(get()) }
}