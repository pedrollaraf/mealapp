package com.pedrollaraf.mealapp.presentation.ui.delegation

import com.pedrollaraf.mealapp.domain.models.Meal
import com.pedrollaraf.mealapp.domain.usecases.abs.MealFavoriteUseCase

class MealFavoriteDelegationManagerImpl(private val mealFavoriteUseCase : MealFavoriteUseCase): MealFavoriteDelegationManager {
    override suspend fun addMealOnFavoriteList(meal: Meal) {
        mealFavoriteUseCase.addMealOnFavoriteList(meal)
    }
}