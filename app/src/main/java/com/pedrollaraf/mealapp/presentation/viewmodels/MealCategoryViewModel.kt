package com.pedrollaraf.mealapp.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pedrollaraf.mealapp.domain.usecases.abs.GetMealCategoriesUseCase
import kotlinx.coroutines.launch

class MealCategoryViewModel(private val getMealCategoriesUseCase: GetMealCategoriesUseCase) : ViewModel() {

    fun getMealCategories() {
        viewModelScope.launch {
            getMealCategoriesUseCase.invoke()
        }
    }
}