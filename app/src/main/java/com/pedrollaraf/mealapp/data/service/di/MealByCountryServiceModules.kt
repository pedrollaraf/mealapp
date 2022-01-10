package com.pedrollaraf.mealapp.data.service.di

import com.pedrollaraf.mealapp.common.utils.ServiceApi
import com.pedrollaraf.mealapp.data.service.abs.MealByCountryApi
import org.koin.dsl.module

fun getMealByCountryServiceModules() = module {
    factory { ServiceApi().createService(MealByCountryApi::class.java) }
}