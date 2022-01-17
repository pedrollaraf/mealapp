package com.pedrollaraf.mealapp.data.datasource.local.commons

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.pedrollaraf.mealapp.data.datasource.local.dao.MealFavoriteDao
import com.pedrollaraf.mealapp.data.datasource.local.entity.MealFavoriteEntity

@Database(entities = [MealFavoriteEntity::class], version = 1)
abstract class RoomLocalDataBase : RoomDatabase() {
    abstract fun mealFavoriteDao(): MealFavoriteDao

    companion object {
        const val DATABASE_NAME = "MealAppDB"
    }
}