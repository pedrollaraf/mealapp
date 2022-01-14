package com.pedrollaraf.mealapp.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pedrollaraf.mealapp.domain.models.MealSearch
import com.pedrollaraf.mealapp.domain.usecases.abs.MealSearchListUseCase
import kotlinx.coroutines.launch

class MealSearchViewModel(
    private val mealSearchListUseCase : MealSearchListUseCase
) : ViewModel() {

    private val mealHomeSearchListMutableLiveData = MutableLiveData<List<MealSearch>>()
    val mealHomeSearchListLiveData: LiveData<List<MealSearch>>
        get() = mealHomeSearchListMutableLiveData

    fun getHomeSearchMeals(query : String) {
        viewModelScope.launch {
            val homeListMeals = mealSearchListUseCase.invoke(query)
            mealHomeSearchListMutableLiveData.postValue(homeListMeals)
        }
    }

}