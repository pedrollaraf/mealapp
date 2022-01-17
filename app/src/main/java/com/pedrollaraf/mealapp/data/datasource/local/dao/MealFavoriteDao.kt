package com.pedrollaraf.mealapp.data.datasource.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.pedrollaraf.mealapp.data.datasource.local.entity.MealFavoriteEntity

@Dao
interface MealFavoriteDao {
    @Query("SELECT * FROM MealFavoriteEntity")
    suspend fun getAll(): List<MealFavoriteEntity>

    @Insert
    suspend fun insert(mealEntity: MealFavoriteEntity)

    @Delete
    suspend fun delete(mealEntity: MealFavoriteEntity)
}