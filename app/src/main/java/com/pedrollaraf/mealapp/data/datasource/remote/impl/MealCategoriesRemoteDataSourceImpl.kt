package com.pedrollaraf.mealapp.data.datasource.remote.impl

import com.pedrollaraf.mealapp.data.datasource.remote.abs.MealCategoriesRemoteDataSource
import com.pedrollaraf.mealapp.data.datasource.remote.service.abs.MealCategoriesApi
import java.lang.Exception

class MealCategoriesRemoteDataSourceImpl(private val serviceMealCategories: MealCategoriesApi) : MealCategoriesRemoteDataSource {
    override suspend fun getMealCategories(){
        try{
            val result = serviceMealCategories.getMealCategories()
            if(result.isSuccessful){
                val teste = result.body()
                val lalala = teste?.categories?.size
            }else {
                val teste2 = ""
            }

        }catch (e : Exception){
            val asdas = e.message
        }
    }
}