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
import com.pedrollaraf.mealapp.databinding.FragmentMealCountriesBinding
import com.pedrollaraf.mealapp.presentation.eventclick.EventClickItemMealCountries
import com.pedrollaraf.mealapp.presentation.ui.activity.MainActivity
import com.pedrollaraf.mealapp.presentation.ui.adapters.MealCountriesAdapter
import com.pedrollaraf.mealapp.presentation.viewmodels.MealCountriesViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MealCountriesFragment : Fragment(), ObservableEvents {

    private var _binding: FragmentMealCountriesBinding? = null
    private val viewBinding get() = _binding!!

    private val viewModel: MealCountriesViewModel by viewModel()
    private var mealCountriesAdapter = MealCountriesAdapter(mealCountries = listOf())

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMealCountriesBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initObservables()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getListCountries()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun initObservables() {
        viewModel.mealCountriesLiveData.observe(viewLifecycleOwner, Observer {
            (activity as MainActivity).showHideProgressBar(false)
            when {
                it.isNotEmpty() -> {
                    viewBinding.recyclerViewMealCountries.visibility = View.VISIBLE
                    viewBinding.titleNoData.visibility = View.GONE
                    mealCountriesAdapter.updateList(it)
                }
                else -> {
                    viewBinding.titleNoData.visibility = View.VISIBLE
                }
            }
        })

        mealCountriesAdapter.eventClickItemMealCountries =
            object : EventClickItemMealCountries {
                override fun onClickItemMealByCountry(country: String) {
                    findNavController().navigate(
                        MealCountriesFragmentDirections.
                        actionMealCountriesFragmentToListMealFragment(
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
    }


    private fun setupAdapter() {
        viewBinding.recyclerViewMealCountries.layoutManager =
            StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
        viewBinding.recyclerViewMealCountries.adapter = mealCountriesAdapter
    }
}