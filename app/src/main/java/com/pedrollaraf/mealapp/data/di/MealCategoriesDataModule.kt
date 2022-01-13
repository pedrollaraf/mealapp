package com.pedrollaraf.mealapp.data.di

import com.pedrollaraf.mealapp.data.repository.MealCategoriesRepositoryImpl
import com.pedrollaraf.mealapp.data.repository.MealListFromCategoryRepositoryImpl
import com.pedrollaraf.mealapp.domain.repository.MealCategoriesRepository
import com.pedrollaraf.mealapp.domain.repository.MealListFromCategoryRepository
import org.koin.dsl.module

fun getMealCategoriesDataModules() = module {
    factory<MealCategoriesRepository> {
        MealCategoriesRepositoryImpl(
            mealCategoriesRemoteDataSource = get()
        )
    }

    factory<MealListFromCategoryRepository> {
        MealListFromCategoryRepositoryImpl(
            mealListFromCategoryRemoteDataSource = get()
        )
    }
}