package com.pedrollaraf.mealapp.domain.repository

import com.pedrollaraf.mealapp.domain.models.Meal

interface MealSearchListRepository {
    suspend fun getSearchMeals(query : String) : List<Meal>
}