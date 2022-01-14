package com.pedrollaraf.mealapp.data.datasource.remote.di

import com.pedrollaraf.mealapp.data.datasource.remote.abs.MealSearchListRemoteDataSource
import com.pedrollaraf.mealapp.data.datasource.remote.impl.MealSearchListRemoteDataSourceImpl
import org.koin.dsl.module

fun getMealSearchDataSourceModules() = module {
    factory<MealSearchListRemoteDataSource> {
        MealSearchListRemoteDataSourceImpl(
            serviceMealSearchList = get()
        )
    }
}