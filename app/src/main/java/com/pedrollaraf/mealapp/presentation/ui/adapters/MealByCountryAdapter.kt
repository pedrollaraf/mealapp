package com.pedrollaraf.mealapp.presentation.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pedrollaraf.mealapp.databinding.ItemMealCountryBinding
import com.pedrollaraf.mealapp.domain.models.MealByCategory
import com.pedrollaraf.mealapp.domain.models.MealByCountry
import com.pedrollaraf.mealapp.presentation.eventclick.EventClickItemMealByCountryOnList

class MealByCountryAdapter(
    private var listMealByCountries: List<MealByCountry>
) : RecyclerView.Adapter<MealByCountryAdapter.ViewHolder>() {

    private lateinit var viewBinding: ItemMealCountryBinding
    var eventClickItemMealByCountryOnList: EventClickItemMealByCountryOnList? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        viewBinding =
            ItemMealCountryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(viewBinding.root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val rowItem = listMealByCountries[position]
        holder.bindView(rowItem, viewBinding, eventClickItemMealByCountryOnList)
    }

    override fun getItemCount(): Int {
        return listMealByCountries.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(newList : List<MealByCountry>){
        listMealByCountries = newList
        this.notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(
            item: MealByCountry,
            viewBinding: ItemMealCountryBinding,
            eventClickItemMealByCountryOnList: EventClickItemMealByCountryOnList?
        ) {
            viewBinding.titleItemMealByCountry.text = item.strArea

            viewBinding.mealCountryButton.setOnClickListener {
                eventClickItemMealByCountryOnList?.onClickItemMealByCountry(item.strArea)
            }

        }
    }
}