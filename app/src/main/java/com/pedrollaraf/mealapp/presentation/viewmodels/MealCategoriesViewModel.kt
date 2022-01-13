package com.pedrollaraf.mealapp.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pedrollaraf.mealapp.domain.models.MealCategory
import com.pedrollaraf.mealapp.domain.usecases.abs.GetMealCategoriesUseCase
import kotlinx.coroutines.launch

class MealCategoriesViewModel(
    private val getMealCategoriesUseCase: GetMealCategoriesUseCase
) : ViewModel() {

    private val mealCategoriesMutableLiveData = MutableLiveData<List<MealCategory>>()
    val mealCategoriesLiveData: LiveData<List<MealCategory>>
        get() = mealCategoriesMutableLiveData

    fun getListCategories() {
        viewModelScope.launch {
            val listMealCategories = getMealCategoriesUseCase.invoke()
            mealCategoriesMutableLiveData.postValue(listMealCategories)
        }
    }
}