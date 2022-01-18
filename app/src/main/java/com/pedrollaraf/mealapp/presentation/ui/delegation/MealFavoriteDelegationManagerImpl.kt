package com.pedrollaraf.mealapp.presentation.ui.delegation

import com.pedrollaraf.mealapp.domain.models.Meal
import com.pedrollaraf.mealapp.domain.usecases.abs.MealFavoriteUseCase

class MealFavoriteDelegationManagerImpl(
    private val mealFavoriteUseCase: MealFavoriteUseCase
) : MealFavoriteDelegationManager {

    override suspend fun addMealOnFavoriteList(meal: Meal): String {
        return mealFavoriteUseCase.addMealOnFavoriteList(meal)
    }

    override suspend fun removeMealOnFavoriteList(meal: Meal): String {
        return mealFavoriteUseCase.removeMealOnFavoriteList(meal)
    }

    override suspend fun getListMealFavorite(): List<Meal> {
        return mealFavoriteUseCase.getListMealFavorite()
    }
}