package com.pedrollaraf.mealapp.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pedrollaraf.mealapp.domain.models.MealCountry
import com.pedrollaraf.mealapp.domain.usecases.abs.MealCountriesUseCase
import kotlinx.coroutines.launch

class MealCountriesViewModel(
    private val mealCountriesUseCase: MealCountriesUseCase
) : ViewModel() {

    private val mealCountriesMutableLiveData = MutableLiveData<List<MealCountry>>()
    val mealCountriesLiveData: LiveData<List<MealCountry>>
        get() = mealCountriesMutableLiveData

    fun getListCountries() {
        viewModelScope.launch {
            val listMealCountries = mealCountriesUseCase.invoke()
            mealCountriesMutableLiveData.postValue(listMealCountries)
        }
    }
}