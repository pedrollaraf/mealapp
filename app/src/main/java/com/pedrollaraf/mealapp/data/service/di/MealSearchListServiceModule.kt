package com.pedrollaraf.mealapp.data.service.di

import com.pedrollaraf.mealapp.common.utils.ServiceApi
import com.pedrollaraf.mealapp.data.service.abs.MealSearchListApi
import org.koin.dsl.module

fun getMealSearchServiceModules() = module {
    factory { ServiceApi().createService(MealSearchListApi::class.java) }
}