package com.pedrollaraf.mealapp.data.datasource.remote.di

import com.pedrollaraf.mealapp.data.datasource.remote.abs.MealCategoriesRemoteDataSource
import com.pedrollaraf.mealapp.data.datasource.remote.abs.MealListFromCategoryRemoteDataSource
import com.pedrollaraf.mealapp.data.datasource.remote.impl.MealCategoriesRemoteDataSourceImpl
import com.pedrollaraf.mealapp.data.datasource.remote.impl.MealListFromCategoryRemoteDataSourceImpl
import org.koin.dsl.module


fun getMealCategoriesDataSourceModules() = module {
    factory<MealCategoriesRemoteDataSource> { MealCategoriesRemoteDataSourceImpl(
        serviceMealCategories = get()
    ) }

    factory<MealListFromCategoryRemoteDataSource> { MealListFromCategoryRemoteDataSourceImpl(
        serviceMealListCategory = get()
    ) }

}