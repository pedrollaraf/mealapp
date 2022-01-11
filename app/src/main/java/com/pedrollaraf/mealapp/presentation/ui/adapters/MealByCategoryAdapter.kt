package com.pedrollaraf.mealapp.presentation.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.pedrollaraf.mealapp.R
import com.pedrollaraf.mealapp.databinding.ItemMealCategoriesBinding
import com.pedrollaraf.mealapp.domain.models.MealByCategory
import com.pedrollaraf.mealapp.presentation.eventclick.EventClickItemMealByCategoryOnList

class MealByCategoryAdapter(private var listMealByCategories: List<MealByCategory>) :
    RecyclerView.Adapter<MealByCategoryAdapter.MealCategoryViewHolder>() {

    var eventClickItemMealByCategoryOnList: EventClickItemMealByCategoryOnList? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealCategoryViewHolder {
        val viewBinding = ItemMealCategoriesBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return MealCategoryViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: MealCategoryViewHolder, position: Int) {
        val item = listMealByCategories[position]
        holder.bindView(item, eventClickItemMealByCategoryOnList)
    }

    override fun getItemCount(): Int {
        return listMealByCategories.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(newList: List<MealByCategory>) {
        listMealByCategories = newList
        this.notifyDataSetChanged()
    }

    class MealCategoryViewHolder(private val viewBinding: ItemMealCategoriesBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {

        fun bindView(
            item: MealByCategory,
            eventClickItemMealByCategoryOnList: EventClickItemMealByCategoryOnList?
        ) {
            viewBinding.titleItemMealByCountry.text = item.strCategory
            viewBinding.imageItemMealByCategory.load(item.strCategoryThumb) {
                listener(
                    // pass two arguments
                    onSuccess = { _, _ ->
                        viewBinding.progressBarImage.visibility = View.GONE
                        viewBinding.imageItemMealByCategory.visibility = View.VISIBLE
                    },
                    onError = { _, _ ->
                        viewBinding.progressBarImage.visibility = View.GONE
                        viewBinding.imageItemMealByCategory.visibility = View.VISIBLE
                        viewBinding.imageItemMealByCategory.setImageResource(R.drawable.ic_error)
                    }
                )
            }

            viewBinding.mealCategoryButton.setOnClickListener {
                eventClickItemMealByCategoryOnList?.onClickItemMealByCategory(item.strCategory)
            }
        }
    }

}