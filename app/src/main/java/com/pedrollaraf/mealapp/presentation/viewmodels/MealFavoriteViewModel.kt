package com.pedrollaraf.mealapp.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pedrollaraf.mealapp.domain.models.Meal
import com.pedrollaraf.mealapp.presentation.ui.delegation.MealFavoriteDelegationManager
import kotlinx.coroutines.launch

class MealFavoriteViewModel(
    private val mealFavoriteDelegationManager : MealFavoriteDelegationManager
) : ViewModel() {


    private val mealFavoriteMutableLiveData = MutableLiveData<List<Meal>>()
    val mealFavoriteLiveData: LiveData<List<Meal>> get() = mealFavoriteMutableLiveData

    fun getListFavorite(){
        viewModelScope.launch {
            val listFavorite = mealFavoriteDelegationManager.getListMealFavorite()
            mealFavoriteMutableLiveData.postValue(listFavorite)
        }
    }

}