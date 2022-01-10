package com.pedrollaraf.mealapp.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pedrollaraf.mealapp.databinding.ItemMealCountryBinding
import com.pedrollaraf.mealapp.domain.models.Country

class CountriesAdapter(
    private var listCountries: List<Country>
) : RecyclerView.Adapter<CountriesAdapter.ViewHolder>() {

    private lateinit var viewBinding: ItemMealCountryBinding

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        viewBinding =
            ItemMealCountryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(viewBinding.root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val rowItem = listCountries[position]
        holder.bindView(rowItem, viewBinding)
    }

    override fun getItemCount(): Int {
        return listCountries.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(item: Country, viewBinding: ItemMealCountryBinding) {
            viewBinding.titleItemMealType.text = item.strArea
        }
    }
}