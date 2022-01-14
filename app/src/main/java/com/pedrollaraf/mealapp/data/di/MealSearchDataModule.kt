package com.pedrollaraf.mealapp.data.di

import com.pedrollaraf.mealapp.data.repository.MealSearchListRepositoryImpl
import com.pedrollaraf.mealapp.domain.repository.MealSearchListRepository
import org.koin.dsl.module


fun getMealSearchDataModules() = module {
    factory<MealSearchListRepository> {
        MealSearchListRepositoryImpl(
            mealSearchListDataSource = get()
        )
    }
}