package com.pedrollaraf.mealapp.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pedrollaraf.mealapp.domain.models.Country
import com.pedrollaraf.mealapp.domain.models.MealCategory
import com.pedrollaraf.mealapp.domain.usecases.abs.GetCountriesUseCase
import kotlinx.coroutines.launch

class CountryViewModel(private val getCountriesUseCase: GetCountriesUseCase) : ViewModel() {

    private val listCountriesMutableLiveData = MutableLiveData<List<Country>>()
    val listCountriesLiveData: LiveData<List<Country>>
        get() = listCountriesMutableLiveData

    fun getMealCountry() {
        viewModelScope.launch {
            val listMealCountry = getCountriesUseCase.invoke()
            listCountriesMutableLiveData.postValue(listMealCountry)
        }
    }
}