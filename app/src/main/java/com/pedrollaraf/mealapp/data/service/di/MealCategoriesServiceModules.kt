package com.pedrollaraf.mealapp.data.service.di

import com.pedrollaraf.mealapp.common.utils.ServiceApi
import com.pedrollaraf.mealapp.data.service.abs.MealCategoriesApi
import com.pedrollaraf.mealapp.data.service.abs.MealListCategoryService
import org.koin.dsl.module

fun getMealCategoriesServiceModules() = module {
    factory { ServiceApi().createService(MealCategoriesApi::class.java) }
    factory { ServiceApi().createService(MealListCategoryService::class.java) }
}