package com.pedrollaraf.mealapp.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.pedrollaraf.mealapp.common.utils.ObservableEvents
import com.pedrollaraf.mealapp.databinding.FragmentMealByCountryBinding
import com.pedrollaraf.mealapp.presentation.eventclick.EventClickItemMealByCountryOnList
import com.pedrollaraf.mealapp.presentation.ui.activity.MainActivity
import com.pedrollaraf.mealapp.presentation.ui.adapters.MealByCountryAdapter
import com.pedrollaraf.mealapp.presentation.viewmodels.MealByCountryViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MealByCountryFragment : Fragment(), ObservableEvents {

    private var _binding: FragmentMealByCountryBinding? = null
    private val viewBinding get() = _binding!!

    private val viewModelMealBy: MealByCountryViewModel by viewModel()
    private lateinit var mealByCountryAdapter: MealByCountryAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMealByCountryBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initObservables()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun initObservables() {
        viewModelMealBy.listMealByCountryLiveData.observe(viewLifecycleOwner, Observer {
            (activity as MainActivity).showHideProgressBar(false)
            when {
                it.isNotEmpty() -> {
                    viewBinding.recyclerViewMealByCountry.visibility = View.VISIBLE
                    viewBinding.titleNoData.visibility = View.GONE
                    mealByCountryAdapter.updateList(it)
                }
                else -> {
                    viewBinding.titleNoData.visibility = View.VISIBLE
                }
            }
        })

        mealByCountryAdapter.eventClickItemMealByCountryOnList =
            object : EventClickItemMealByCountryOnList {
                override fun onClickItemMealByCountry(country: String) {
                    findNavController().navigate(
                        MealByCountryFragmentDirections.
                        actionMealByCountryFragmentToTypeMealFragment(
                            null,
                            country
                        )
                    )
                }
            }
    }

    private fun initView() {
        viewBinding.titleNoData.visibility = View.GONE
        (activity as MainActivity).showHideProgressBar(true)
        setupAdapter()
        viewModelMealBy.getMealCountry()
    }


    private fun setupAdapter() {
        mealByCountryAdapter = MealByCountryAdapter(listMealByCountries = listOf())
        viewBinding.recyclerViewMealByCountry.layoutManager =
            StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
        viewBinding.recyclerViewMealByCountry.adapter = mealByCountryAdapter
    }
}