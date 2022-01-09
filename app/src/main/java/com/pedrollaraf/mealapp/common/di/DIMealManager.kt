package com.pedrollaraf.mealapp.common.di

import android.app.Application
import android.content.Context
import org.koin.android.ext.android.getKoin
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.dsl.bind
import org.koin.dsl.module

class DIMealManager {

    fun initMealDependenceInjection(context: Application) {
        try {
            context.getKoin()
        } catch (e: Exception) {
            startKoin(KoinApplication.init())
        } finally {
            context.getKoin().apply {
                loadModules(
                    listOf(
                        module {
                            single<Context> { context } bind Application::class
                        }
                    )
                )
                /*loadModules(DataModule().get())
                loadModules(DomainModule().get())*/
                loadModules(ViewModelModules().get())
            }
        }
    }
}