package com.pedrollaraf.mealapp.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pedrollaraf.mealapp.domain.models.MealByCountry
import com.pedrollaraf.mealapp.domain.usecases.abs.GetMealByCountryUseCase
import kotlinx.coroutines.launch

class MealByCountryViewModel(private val getMealByCountryUseCase: GetMealByCountryUseCase) : ViewModel() {

    private val listMealByCountryMutableLiveData = MutableLiveData<List<MealByCountry>>()
    val listMealByCountryLiveData: LiveData<List<MealByCountry>>
        get() = listMealByCountryMutableLiveData

    fun getMealCountry() {
        viewModelScope.launch {
            val listMealCountries = getMealByCountryUseCase.invoke()
            listMealByCountryMutableLiveData.postValue(listMealCountries)
        }
    }
}