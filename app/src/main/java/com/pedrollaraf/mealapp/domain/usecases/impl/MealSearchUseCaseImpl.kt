package com.pedrollaraf.mealapp.domain.usecases.impl

import com.pedrollaraf.mealapp.domain.models.Meal
import com.pedrollaraf.mealapp.domain.repository.MealSearchListRepository
import com.pedrollaraf.mealapp.domain.usecases.abs.MealSearchUseCase

class MealSearchUseCaseImpl(
    private val mealSearchRepository : MealSearchListRepository
) : MealSearchUseCase {
    override suspend fun invoke(query: String): Meal? {
        val resultList = mealSearchRepository.getSearchMeals(query)
        return if(resultList.isNullOrEmpty()){
            null
        }else{
            resultList.first()
        }
    }
}