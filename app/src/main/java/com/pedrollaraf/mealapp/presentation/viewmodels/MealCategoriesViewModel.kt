package com.pedrollaraf.mealapp.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pedrollaraf.mealapp.domain.models.MealCategory
import com.pedrollaraf.mealapp.domain.usecases.abs.MealCategoriesUseCase
import kotlinx.coroutines.launch

class MealCategoriesViewModel(
    private val mealCategoriesUseCase: MealCategoriesUseCase
) : ViewModel() {

    private val mealCategoriesMutableLiveData = MutableLiveData<List<MealCategory>>()
    val mealCategoriesLiveData: LiveData<List<MealCategory>>
        get() = mealCategoriesMutableLiveData

    fun getListCategories() {
        viewModelScope.launch {
            val listMealCategories = mealCategoriesUseCase.invoke()
            mealCategoriesMutableLiveData.postValue(listMealCategories)
        }
    }
}