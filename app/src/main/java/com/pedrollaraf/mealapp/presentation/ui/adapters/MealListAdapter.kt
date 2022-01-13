package com.pedrollaraf.mealapp.presentation.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.pedrollaraf.mealapp.R
import com.pedrollaraf.mealapp.databinding.ItemMealBinding
import com.pedrollaraf.mealapp.domain.models.MealFromCategoryOrCountry
import com.pedrollaraf.mealapp.presentation.eventclick.EventClickItemMealList

class MealListAdapter(private var mealFromCategoryOrCountryList: List<MealFromCategoryOrCountry>) :
    RecyclerView.Adapter<MealListAdapter.MealListViewHolder>() {

    var eventClickItemMealList: EventClickItemMealList? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealListViewHolder {
        val viewBinding = ItemMealBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return MealListViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: MealListViewHolder, position: Int) {
        val item = mealFromCategoryOrCountryList[position]
        holder.bindView(item,eventClickItemMealList)
    }

    override fun getItemCount(): Int {
        return mealFromCategoryOrCountryList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(newList: List<MealFromCategoryOrCountry>) {
        mealFromCategoryOrCountryList = newList
        this.notifyDataSetChanged()
    }

    class MealListViewHolder(private val viewBinding: ItemMealBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {

        fun bindView(
            item: MealFromCategoryOrCountry,
            eventClickItemMealList: EventClickItemMealList?
        ) {
            viewBinding.titleItemMealList.text = item.strMeal
            viewBinding.imageItemMealList.load(item.strMealThumb) {
                listener(
                    // pass two arguments
                    onSuccess = { _, _ ->
                        viewBinding.progressBarImage.visibility = View.GONE
                        viewBinding.imageItemMealList.visibility = View.VISIBLE
                    },
                    onError = { _, _ ->
                        viewBinding.progressBarImage.visibility = View.GONE
                        viewBinding.imageItemMealList.visibility = View.VISIBLE
                        viewBinding.imageItemMealList.setImageResource(R.drawable.ic_error)
                    }
                )
            }

            viewBinding.mealCategoryButton.setOnClickListener {
                eventClickItemMealList?.onClickItemMealList(item.strMeal)
            }
        }
    }
}