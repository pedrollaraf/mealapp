package com.pedrollaraf.mealapp.presentation.eventclick

import com.pedrollaraf.mealapp.domain.models.Meal

interface EventClickItemMealSearchOrFavoriteList {
    fun onClickItemMealSearchFavoriteList(item:Meal)
}