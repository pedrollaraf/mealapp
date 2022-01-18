package com.pedrollaraf.mealapp.presentation.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.pedrollaraf.mealapp.R
import com.pedrollaraf.mealapp.databinding.ItemMealSearchFavoriteBinding
import com.pedrollaraf.mealapp.domain.models.Meal
import com.pedrollaraf.mealapp.presentation.eventclick.EventClickItemMealSearchOrFavoriteList

class MealSearchFavoriteListAdapter(private var searchFavoriteList: List<Meal>) :
    RecyclerView.Adapter<MealSearchFavoriteListAdapter.HomeSearchViewHolder>() {

    var eventClickItemMealSearchOrFavoriteList: EventClickItemMealSearchOrFavoriteList? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeSearchViewHolder {
        val viewBinding = ItemMealSearchFavoriteBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return HomeSearchViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: HomeSearchViewHolder, position: Int) {
        val item = searchFavoriteList[position]
        holder.bindView(item, eventClickItemMealSearchOrFavoriteList)
    }

    override fun getItemCount(): Int {
        return searchFavoriteList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(newList: List<Meal>) {
        searchFavoriteList = newList
        this.notifyDataSetChanged()
    }

    class HomeSearchViewHolder(private val viewBinding: ItemMealSearchFavoriteBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {

        fun bindView(
            item: Meal,
            eventClickItemMealSearchOrFavoriteList: EventClickItemMealSearchOrFavoriteList?
        ) {
            viewBinding.titleItemMealSearch.text = item.strMeal
            "Category: ${item.strCategory}".also { viewBinding.titleItemMealCategory.text = it }
            "Country: ${item.strArea}".also { viewBinding.titleItemMealCountry.text = it }
            "Tags: ${item.strTags}".also { viewBinding.titleItemMealSearchTag.text = it }
            viewBinding.imageItemMealSearch.load(item.strMealThumb) {
                listener(
                    // pass two arguments
                    onSuccess = { _, _ ->
                        viewBinding.progressBarImage.visibility = View.GONE
                        viewBinding.imageItemMealSearch.visibility = View.VISIBLE
                        viewBinding.imageItemMealSearch.scaleType = ImageView.ScaleType.CENTER_CROP
                    },
                    onError = { _, _ ->
                        viewBinding.progressBarImage.visibility = View.GONE
                        viewBinding.imageItemMealSearch.visibility = View.VISIBLE
                        viewBinding.imageItemMealSearch.scaleType = ImageView.ScaleType.FIT_CENTER
                        viewBinding.imageItemMealSearch.setImageResource(R.drawable.ic_error)
                    }
                )
            }

            viewBinding.mealCategoryButton.setOnClickListener {
                eventClickItemMealSearchOrFavoriteList?.onClickItemMealSearchFavoriteList(item)
            }
        }
    }
}