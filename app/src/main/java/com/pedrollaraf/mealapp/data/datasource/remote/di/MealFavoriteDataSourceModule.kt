package com.pedrollaraf.mealapp.data.datasource.remote.di

import com.pedrollaraf.mealapp.data.datasource.local.abs.MealFavoriteLocalDataSource
import com.pedrollaraf.mealapp.data.datasource.local.impl.MealFavoriteLocalDataSourceImpl
import org.koin.dsl.module

fun getMealFavoriteDataSourceModules() = module {
    factory<MealFavoriteLocalDataSource> {
        MealFavoriteLocalDataSourceImpl(
            roomLocalDataBase = get()
        )
    }
}