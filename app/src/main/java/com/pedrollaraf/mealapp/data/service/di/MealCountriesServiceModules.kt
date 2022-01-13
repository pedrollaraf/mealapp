package com.pedrollaraf.mealapp.data.service.di

import com.pedrollaraf.mealapp.common.utils.ServiceApi
import com.pedrollaraf.mealapp.data.service.abs.MealCountriesApi
import com.pedrollaraf.mealapp.data.service.abs.MealListCountryService
import org.koin.dsl.module

fun getMealCountriesServiceModules() = module {
    factory { ServiceApi().createService(MealCountriesApi::class.java) }
    factory { ServiceApi().createService(MealListCountryService::class.java) }
}