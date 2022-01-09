package com.pedrollaraf.mealapp.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MealCategoryViewModel : ViewModel() {

    fun getMealCategories() {
        viewModelScope.launch {
            val teste = ""
        }
    }
}