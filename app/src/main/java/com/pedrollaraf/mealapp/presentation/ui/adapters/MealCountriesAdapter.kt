package com.pedrollaraf.mealapp.presentation.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pedrollaraf.mealapp.databinding.ItemMealCountryBinding
import com.pedrollaraf.mealapp.domain.models.MealCountry
import com.pedrollaraf.mealapp.presentation.eventclick.EventClickItemMealCountries

class MealCountriesAdapter(private var mealCountries: List<MealCountry>/*, private val context: Context*/) :
    RecyclerView.Adapter<MealCountriesAdapter.ListItemsViewHolder>() {

    var eventClickItemMealCountries: EventClickItemMealCountries? = null

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
        val item = mealCountries[position]
        holder.bindView(item, eventClickItemMealCountries)
    }

    override fun getItemCount(): Int {
        return mealCountries.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(newList: List<MealCountry>) {
        mealCountries = newList
        this.notifyDataSetChanged()
    }

    class ListItemsViewHolder(private val viewBinding: ItemMealCountryBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {
        fun bindView(
            item: MealCountry,
            eventClickItemMealCountries: EventClickItemMealCountries?
        ) {
            viewBinding.titleItemMealCountries.text = item.strArea

            viewBinding.mealCountryButton.setOnClickListener {
                eventClickItemMealCountries?.onClickItemMealByCountry(item.strArea)
            }

        }
    }

}