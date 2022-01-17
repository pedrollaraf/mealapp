package com.pedrollaraf.mealapp.data.di

import com.pedrollaraf.mealapp.data.repository.MealFavoriteRepositoryImpl
import com.pedrollaraf.mealapp.domain.repository.MealFavoriteRepository
import org.koin.dsl.module

fun getMealFavoriteDataModules() = module {
    factory<MealFavoriteRepository> {
        MealFavoriteRepositoryImpl(mealFavoriteLocalDataSource = get())
    }
}