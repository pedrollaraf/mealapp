package com.pedrollaraf.mealapp.domain.di


import com.pedrollaraf.mealapp.domain.usecases.abs.MealCategoriesUseCase
import com.pedrollaraf.mealapp.domain.usecases.abs.MealListFromCategoryUseCase
import com.pedrollaraf.mealapp.domain.usecases.impl.MealCategoriesUseCaseImpl
import com.pedrollaraf.mealapp.domain.usecases.impl.MealListFromCategoryUseCaseImpl
import org.koin.dsl.module

fun getMealCategoriesDomainModules() = module {
    factory<MealCategoriesUseCase> { MealCategoriesUseCaseImpl(
        getMealCategoriesRepository = get()
    )}
    factory<MealListFromCategoryUseCase> { MealListFromCategoryUseCaseImpl(
        mealListFromCategoryRepository = get()
    ) }
}