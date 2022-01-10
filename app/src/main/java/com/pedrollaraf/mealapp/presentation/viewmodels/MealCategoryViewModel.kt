package com.pedrollaraf.mealapp.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pedrollaraf.mealapp.domain.models.MealCategory
import com.pedrollaraf.mealapp.domain.usecases.abs.GetMealCategoriesUseCase
import kotlinx.coroutines.launch

class MealCategoryViewModel(private val getMealCategoriesUseCase: GetMealCategoriesUseCase) :
    ViewModel() {

    private val listMealCategoriesMutableLiveData = MutableLiveData<List<MealCategory>>()
    val listMealCategoriesLiveData: LiveData<List<MealCategory>>
        get() = listMealCategoriesMutableLiveData

    fun getMealCategories() {
        viewModelScope.launch {
            val listMealCategories = getMealCategoriesUseCase.invoke()
            listMealCategoriesMutableLiveData.postValue(listMealCategories)
        }
    }
}