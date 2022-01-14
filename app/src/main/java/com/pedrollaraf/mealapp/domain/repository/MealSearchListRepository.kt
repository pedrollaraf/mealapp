package com.pedrollaraf.mealapp.domain.repository

import com.pedrollaraf.mealapp.domain.models.MealSearch

interface MealSearchListRepository {
    suspend fun getHomeSearchMeals(query : String) : List<MealSearch>
}