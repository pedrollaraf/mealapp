package com.pedrollaraf.mealapp.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pedrollaraf.mealapp.domain.models.MealFromCategoryOrCountry
import com.pedrollaraf.mealapp.domain.usecases.abs.GetMealListFromCountryUseCase
import kotlinx.coroutines.launch

class MealListFromCountryViewModel(
    private val getMealListFromCountryUseCase: GetMealListFromCountryUseCase
    ) : ViewModel() {

    private val listMealFromCountryMutableLiveData = MutableLiveData<List<MealFromCategoryOrCountry>>()
    val listMealFromCountryLiveData: LiveData<List<MealFromCategoryOrCountry>>
        get() = listMealFromCountryMutableLiveData

    fun getListMealsFromCountry(countryName : String) {
        viewModelScope.launch {
            val listMealFromCountry = getMealListFromCountryUseCase.invoke(countryName)
            listMealFromCountryMutableLiveData.postValue(listMealFromCountry)
        }
    }

}