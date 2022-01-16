package com.pedrollaraf.mealapp.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pedrollaraf.mealapp.domain.models.Meal
import com.pedrollaraf.mealapp.domain.usecases.abs.MealSearchListUseCase
import kotlinx.coroutines.launch

class MealSearchViewModel(
    private val mealSearchListUseCase : MealSearchListUseCase
) : ViewModel() {

    private val mealHomeSearchListMutableLiveData = MutableLiveData<List<Meal>>()
    val mealHomeSearchListLiveData: LiveData<List<Meal>>
        get() = mealHomeSearchListMutableLiveData

    fun getHomeSearchMeals(query : String) {
        viewModelScope.launch {
            val homeListMeals = mealSearchListUseCase.invoke(query)
            mealHomeSearchListMutableLiveData.postValue(homeListMeals)
        }
    }

}