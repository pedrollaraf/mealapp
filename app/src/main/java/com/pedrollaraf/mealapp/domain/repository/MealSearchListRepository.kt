package com.pedrollaraf.mealapp.domain.repository

import com.pedrollaraf.mealapp.domain.models.MealSearch

interface MealSearchListRepository {
    suspend fun getSearchMeals(query : String) : List<MealSearch>
}