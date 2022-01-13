package com.pedrollaraf.mealapp.domain.di


import com.pedrollaraf.mealapp.domain.usecases.abs.GetMealCategoriesUseCase
import com.pedrollaraf.mealapp.domain.usecases.abs.GetMealListFromCategoryUseCase
import com.pedrollaraf.mealapp.domain.usecases.impl.GetMealCategoriesUseCaseImpl
import com.pedrollaraf.mealapp.domain.usecases.impl.GetMealListFromCategoryUseCaseImpl
import org.koin.dsl.module

fun getMealCategoriesDomainModules() = module {
    factory<GetMealCategoriesUseCase> { GetMealCategoriesUseCaseImpl(
        getMealCategoriesRepository = get()
    )}
    factory<GetMealListFromCategoryUseCase> { GetMealListFromCategoryUseCaseImpl(
        mealListFromCategoryRepository = get()
    ) }
}