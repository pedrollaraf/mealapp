package com.pedrollaraf.mealapp.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pedrollaraf.mealapp.domain.models.MealByCategory
import com.pedrollaraf.mealapp.domain.usecases.abs.GetMealByCategoryUseCase
import kotlinx.coroutines.launch

class MealByCategoryViewModel(private val getMealByCategoryUseCase: GetMealByCategoryUseCase) :
    ViewModel() {

    private val listMealByCategoryMutableLiveData = MutableLiveData<List<MealByCategory>>()
    val listMealByByCategoryLiveData: LiveData<List<MealByCategory>>
        get() = listMealByCategoryMutableLiveData

    fun getMealCategories() {
        viewModelScope.launch {
            val listMealCategories = getMealByCategoryUseCase.invoke()
            listMealByCategoryMutableLiveData.postValue(listMealCategories)
        }
    }
}