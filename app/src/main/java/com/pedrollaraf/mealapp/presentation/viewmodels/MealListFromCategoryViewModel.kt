package com.pedrollaraf.mealapp.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pedrollaraf.mealapp.domain.models.MealFromCategoryOrCountry
import com.pedrollaraf.mealapp.domain.usecases.abs.GetMealListFromCategoryUseCase
import kotlinx.coroutines.launch

class MealListFromCategoryViewModel(
    private val getMealListFromCategoryUseCase: GetMealListFromCategoryUseCase
) : ViewModel() {

    private val listMealFromCategoryMutableLiveData = MutableLiveData<List<MealFromCategoryOrCountry>>()
    val listMealFromCategoryLiveData: LiveData<List<MealFromCategoryOrCountry>>
        get() = listMealFromCategoryMutableLiveData

    fun getListMealsFromCategory(categoryName : String) {
        viewModelScope.launch {
            val listMealFromCategory = getMealListFromCategoryUseCase.invoke(categoryName)
            listMealFromCategoryMutableLiveData.postValue(listMealFromCategory)
        }
    }
}