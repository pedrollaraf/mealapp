package com.pedrollaraf.mealapp.data.service.di

import com.pedrollaraf.mealapp.common.utils.ServiceApi
import com.pedrollaraf.mealapp.data.service.abs.CountriesApi
import org.koin.dsl.module

fun getCountriesServiceModules() = module {
    factory { ServiceApi().createService(CountriesApi::class.java) }
}