package com.pedrollaraf.mealapp.presentation.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.pedrollaraf.mealapp.R
import com.pedrollaraf.mealapp.databinding.ItemHomeMealSearchBinding
import com.pedrollaraf.mealapp.domain.models.MealSearch
import com.pedrollaraf.mealapp.presentation.eventclick.EventClickItemMealHomeSearchList

class HomeSearchListAdapter(private var homeSearchList: List<MealSearch>) :
    RecyclerView.Adapter<HomeSearchListAdapter.HomeSearchViewHolder>() {

    var eventClickItemMealHomeSearchList: EventClickItemMealHomeSearchList? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeSearchViewHolder {
        val viewBinding = ItemHomeMealSearchBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return HomeSearchViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: HomeSearchViewHolder, position: Int) {
        val item = homeSearchList[position]
        holder.bindView(item, eventClickItemMealHomeSearchList)
    }

    override fun getItemCount(): Int {
        return homeSearchList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(newList: List<MealSearch>) {
        homeSearchList = newList
        this.notifyDataSetChanged()
    }

    class HomeSearchViewHolder(private val viewBinding: ItemHomeMealSearchBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {

        fun bindView(
            item: MealSearch,
            eventClickItemMealHomeSearchList: EventClickItemMealHomeSearchList?
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
                    },
                    onError = { _, _ ->
                        viewBinding.progressBarImage.visibility = View.GONE
                        viewBinding.imageItemMealSearch.visibility = View.VISIBLE
                        viewBinding.imageItemMealSearch.setImageResource(R.drawable.ic_error)
                    }
                )
            }

            viewBinding.mealCategoryButton.setOnClickListener {
                eventClickItemMealHomeSearchList?.onClickItemMealHomeSearchList(item)
            }
        }
    }
}