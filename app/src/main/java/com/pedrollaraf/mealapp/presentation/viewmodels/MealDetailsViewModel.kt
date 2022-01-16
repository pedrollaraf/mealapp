package com.pedrollaraf.mealapp.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pedrollaraf.mealapp.domain.models.Meal
import com.pedrollaraf.mealapp.domain.usecases.abs.MealSearchUseCase
import com.pedrollaraf.mealapp.presentation.ui.delegation.MealFavoriteDelegationManager
import kotlinx.coroutines.launch

class MealDetailsViewModel(
    private val mealSearchUseCase: MealSearchUseCase,
    private val mealFavoriteDelegationInterface : MealFavoriteDelegationManager
) : ViewModel(),MealFavoriteDelegationManager by mealFavoriteDelegationInterface {

    private val mealSearchMutableLiveData = MutableLiveData<Meal>()
    val mealSearchLiveData: LiveData<Meal>
        get() = mealSearchMutableLiveData

    fun getMealDetails(query: String) {
        viewModelScope.launch {
            val mealDetail = mealSearchUseCase.invoke(query)
            mealSearchMutableLiveData.postValue(mealDetail)
        }
    }

    fun getCompileListIngredients(item: Meal?): String {
        val ingredients = item?.strIngredient1 + "\n" +
                item?.strIngredient2 + "\n" +
                item?.strIngredient3 + "\n" +
                item?.strIngredient4 + "\n" +
                item?.strIngredient5 + "\n" +
                item?.strIngredient6 + "\n" +
                item?.strIngredient7 + "\n" +
                item?.strIngredient8 + "\n" +
                item?.strIngredient9 + "\n" +
                item?.strIngredient10 + "\n" +
                item?.strIngredient11 + "\n" +
                item?.strIngredient12 + "\n" +
                item?.strIngredient13 + "\n" +
                item?.strIngredient14 + "\n" +
                item?.strIngredient15 + "\n" +
                item?.strIngredient16 + "\n" +
                item?.strIngredient17 + "\n" +
                item?.strIngredient18 + "\n" +
                item?.strIngredient19 + "\n" +
                item?.strIngredient20 + "\n"

        return ingredients.trim()
    }

    fun getCompileListMeasures(item: Meal?): String {

        val measures = item?.strMeasure1 + "\n" +
                item?.strMeasure2 + "\n" +
                item?.strMeasure3 + "\n" +
                item?.strMeasure4 + "\n" +
                item?.strMeasure5 + "\n" +
                item?.strMeasure6 + "\n" +
                item?.strMeasure7 + "\n" +
                item?.strMeasure8 + "\n" +
                item?.strMeasure9 + "\n" +
                item?.strMeasure10 + "\n" +
                item?.strMeasure11 + "\n" +
                item?.strMeasure12 + "\n" +
                item?.strMeasure13 + "\n" +
                item?.strMeasure14 + "\n" +
                item?.strMeasure15 + "\n" +
                item?.strMeasure16 + "\n" +
                item?.strMeasure17 + "\n" +
                item?.strMeasure18 + "\n" +
                item?.strMeasure19 + "\n" +
                item?.strMeasure20 + "\n"
        return measures.trim()
    }


    fun favoriteMeal(meal: Meal) {
        val teste = meal
    }

}