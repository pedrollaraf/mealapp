package com.pedrollaraf.mealapp.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pedrollaraf.mealapp.domain.models.MealFromCategoryOrCountry
import com.pedrollaraf.mealapp.domain.usecases.abs.MealListFromCountryUseCase
import kotlinx.coroutines.launch

class MealListFromCountryViewModel(
    private val mealListFromCountryUseCase: MealListFromCountryUseCase
    ) : ViewModel() {

    private val listMealFromCountryMutableLiveData = MutableLiveData<List<MealFromCategoryOrCountry>>()
    val listMealFromCountryLiveData: LiveData<List<MealFromCategoryOrCountry>>
        get() = listMealFromCountryMutableLiveData

    fun getListMealsFromCountry(countryName : String) {
        viewModelScope.launch {
            val listMealFromCountry = mealListFromCountryUseCase.invoke(countryName)
            listMealFromCountryMutableLiveData.postValue(listMealFromCountry)
        }
    }

}