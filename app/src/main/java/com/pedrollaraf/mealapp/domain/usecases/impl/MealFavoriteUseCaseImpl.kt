package com.pedrollaraf.mealapp.domain.usecases.impl

import com.pedrollaraf.mealapp.domain.models.Meal
import com.pedrollaraf.mealapp.domain.repository.MealFavoriteRepository
import com.pedrollaraf.mealapp.domain.usecases.abs.MealFavoriteUseCase

class MealFavoriteUseCaseImpl(private val mealFavoriteRepository: MealFavoriteRepository) : MealFavoriteUseCase {
    override suspend fun addMealOnFavoriteList(meal: Meal): String {
        return mealFavoriteRepository.addMealOnFavoriteList(meal)
    }

    override suspend fun removeMealOnFavoriteList(meal: Meal): String {
        return mealFavoriteRepository.removeMealOnFavoriteList(meal)
    }

    override suspend fun getListMealFavorite(): List<Meal> {
        return mealFavoriteRepository.getListMealFavorite()
    }
}