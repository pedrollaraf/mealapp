package com.pedrollaraf.mealapp.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.pedrollaraf.mealapp.R
import com.pedrollaraf.mealapp.databinding.ItemMealCategoriesBinding
import com.pedrollaraf.mealapp.domain.models.MealCategory

class MealCategoriesAdapter(
    private var listMealCategories: List<MealCategory>
) : RecyclerView.Adapter<MealCategoriesAdapter.ViewHolder>() {

    private lateinit var viewBinding: ItemMealCategoriesBinding

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        viewBinding = ItemMealCategoriesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(viewBinding.root)
    }

    override fun onBindViewHolder(holder: MealCategoriesAdapter.ViewHolder, position: Int) {
        val rowItem = listMealCategories[position]
        holder.bindView(rowItem, viewBinding)
    }

    override fun getItemCount(): Int {
        return listMealCategories.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(
            item: MealCategory,
            viewBinding: ItemMealCategoriesBinding
        ) {
            viewBinding.titleItemMealType.text = item.strCategory
            viewBinding.imageItemMealType.load(item.strCategoryThumb) /*{
                listener(
                    // pass two arguments
                    onSuccess = { _, _ ->
                        viewBinding.progressBarImage.visibility = View.GONE
                        viewBinding.imageItemMealType.visibility = View.VISIBLE
                    },
                    onError = { _, _ ->
                        viewBinding.progressBarImage.visibility = View.GONE
                        error(R.drawable.ic_error)
                    }
                )
            }*/
        }
    }
}