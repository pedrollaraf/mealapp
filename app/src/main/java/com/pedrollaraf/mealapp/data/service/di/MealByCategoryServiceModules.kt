package com.pedrollaraf.mealapp.data.service.di

import com.pedrollaraf.mealapp.common.utils.ServiceApi
import com.pedrollaraf.mealapp.data.service.abs.MealByCategoryApi
import org.koin.dsl.module

fun getMealByCategoryServiceModules() = module {
    factory { ServiceApi().createService(MealByCategoryApi::class.java) }
}