package com.pedrollaraf.mealapp.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.pedrollaraf.mealapp.R
import com.pedrollaraf.mealapp.databinding.ItemMealCategoriesBinding
import com.pedrollaraf.mealapp.domain.models.MealByCategory

class MealByCategoryAdapter(
    private var listMealByCategories: List<MealByCategory>
) : RecyclerView.Adapter<MealByCategoryAdapter.ViewHolder>() {

    private lateinit var viewBinding: ItemMealCategoriesBinding

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        viewBinding = ItemMealCategoriesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(viewBinding.root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val rowItem = listMealByCategories[position]
        holder.bindView(rowItem, viewBinding)
    }

    override fun getItemCount(): Int {
        return listMealByCategories.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(
            item: MealByCategory,
            viewBinding: ItemMealCategoriesBinding
        ) {
            viewBinding.titleItemMealByCountry.text = item.strCategory
            viewBinding.imageItemMealByCategory.load(item.strCategoryThumb){
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
        }
    }
}