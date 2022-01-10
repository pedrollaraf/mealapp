package com.pedrollaraf.mealapp.data.di

import com.pedrollaraf.mealapp.data.repository.MealByCategoryRepositoryImpl
import com.pedrollaraf.mealapp.domain.repository.MealByCategoryRepository
import org.koin.dsl.module

fun getMealByCategoryDataModules() = module {
    factory<MealByCategoryRepository> {
        MealByCategoryRepositoryImpl(
            mealByCategoryRemoteDataSource = get()/*,
            mealCategoriesLocalDataSource = get()*/
        )
    }
}