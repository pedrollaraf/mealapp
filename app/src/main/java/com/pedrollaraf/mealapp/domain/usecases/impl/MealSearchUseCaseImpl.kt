package com.pedrollaraf.mealapp.domain.usecases.impl

import com.pedrollaraf.mealapp.domain.models.MealSearch
import com.pedrollaraf.mealapp.domain.repository.MealSearchListRepository
import com.pedrollaraf.mealapp.domain.usecases.abs.MealSearchUseCase

class MealSearchUseCaseImpl(
    private val mealSearchRepository : MealSearchListRepository
) : MealSearchUseCase {
    override suspend fun invoke(query: String): MealSearch {
        return mealSearchRepository.getSearchMeals(query).first()
    }
}