package com.pedrollaraf.mealapp.domain.usecases.impl

import com.pedrollaraf.mealapp.domain.models.MealSearch
import com.pedrollaraf.mealapp.domain.repository.MealSearchListRepository
import com.pedrollaraf.mealapp.domain.usecases.abs.MealSearchListUseCase

class MealSearchListUseCaseImpl(
    private val mealSearchListRepository : MealSearchListRepository
) : MealSearchListUseCase {
    override suspend fun invoke(query : String): List<MealSearch> {
        return mealSearchListRepository.getHomeSearchMeals(query)
    }
}