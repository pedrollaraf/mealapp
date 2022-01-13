package com.pedrollaraf.mealapp.presentation.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.pedrollaraf.mealapp.R
import com.pedrollaraf.mealapp.databinding.ItemMealCategoriesBinding
import com.pedrollaraf.mealapp.domain.models.MealCategory
import com.pedrollaraf.mealapp.presentation.eventclick.EventClickItemMealCategories

class MealCategoriesAdapter(private var mealCategories: List<MealCategory>) :
    RecyclerView.Adapter<MealCategoriesAdapter.MealCategoryViewHolder>() {

    var eventClickItemMealCategories: EventClickItemMealCategories? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealCategoryViewHolder {
        val viewBinding = ItemMealCategoriesBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return MealCategoryViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: MealCategoryViewHolder, position: Int) {
        val item = mealCategories[position]
        holder.bindView(item, eventClickItemMealCategories)
    }

    override fun getItemCount(): Int {
        return mealCategories.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(newList: List<MealCategory>) {
        mealCategories = newList
        this.notifyDataSetChanged()
    }

    class MealCategoryViewHolder(private val viewBinding: ItemMealCategoriesBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {

        fun bindView(
            item: MealCategory,
            eventClickItemMealCategories: EventClickItemMealCategories?
        ) {
            viewBinding.titleItemMealCategories.text = item.strCategory
            viewBinding.imageItemMealCategories.load(item.strCategoryThumb) {
                listener(
                    // pass two arguments
                    onSuccess = { _, _ ->
                        viewBinding.progressBarImage.visibility = View.GONE
                        viewBinding.imageItemMealCategories.visibility = View.VISIBLE
                    },
                    onError = { _, _ ->
                        viewBinding.progressBarImage.visibility = View.GONE
                        viewBinding.imageItemMealCategories.visibility = View.VISIBLE
                        viewBinding.imageItemMealCategories.setImageResource(R.drawable.ic_error)
                    }
                )
            }

            viewBinding.mealCategoryButton.setOnClickListener {
                eventClickItemMealCategories?.onClickItemMealCategories(item.strCategory)
            }
        }
    }
}