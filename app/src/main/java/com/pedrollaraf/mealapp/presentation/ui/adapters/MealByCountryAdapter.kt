package com.pedrollaraf.mealapp.presentation.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pedrollaraf.mealapp.databinding.ItemMealCountryBinding
import com.pedrollaraf.mealapp.domain.models.MealByCountry
import com.pedrollaraf.mealapp.presentation.eventclick.EventClickItemMealByCountryOnList

class MealByCountryAdapter(private var listMealByCountries: List<MealByCountry>/*, private val context: Context*/) :
    RecyclerView.Adapter<MealByCountryAdapter.ListItemsViewHolder>() {

    var eventClickItemMealByCountryOnList: EventClickItemMealByCountryOnList? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemsViewHolder {
        val itemBinding =
            ItemMealCountryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return ListItemsViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ListItemsViewHolder, position: Int) {
        val item = listMealByCountries[position]
        holder.bindView(item, eventClickItemMealByCountryOnList)
    }

    override fun getItemCount(): Int {
        return listMealByCountries.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(newList: List<MealByCountry>) {
        listMealByCountries = newList
        this.notifyDataSetChanged()
    }

    class ListItemsViewHolder(private val viewBinding: ItemMealCountryBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {
        fun bindView(
            item: MealByCountry,
            eventClickItemMealByCountryOnList: EventClickItemMealByCountryOnList?
        ) {
            viewBinding.titleItemMealByCountry.text = item.strArea

            viewBinding.mealCountryButton.setOnClickListener {
                eventClickItemMealByCountryOnList?.onClickItemMealByCountry(item.strArea)
            }

        }
    }

}