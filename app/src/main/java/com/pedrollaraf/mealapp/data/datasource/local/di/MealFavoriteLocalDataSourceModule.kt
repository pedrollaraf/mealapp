package com.pedrollaraf.mealapp.data.datasource.local.di

import androidx.room.Room
import com.pedrollaraf.mealapp.data.datasource.local.commons.RoomLocalDataBase
import org.koin.dsl.module


internal fun getMealFavoriteLocalDataSourceModules() = module {
    single {
        Room.databaseBuilder(get(), RoomLocalDataBase::class.java, RoomLocalDataBase.DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }
}