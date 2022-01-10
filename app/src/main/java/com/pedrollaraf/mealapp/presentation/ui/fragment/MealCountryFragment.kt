package com.pedrollaraf.mealapp.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.pedrollaraf.mealapp.common.utils.ObservableEvents
import com.pedrollaraf.mealapp.databinding.FragmentMealCountryBinding
import com.pedrollaraf.mealapp.domain.models.Country
import com.pedrollaraf.mealapp.presentation.ui.activity.MainActivity
import com.pedrollaraf.mealapp.presentation.ui.adapters.CountriesAdapter
import com.pedrollaraf.mealapp.presentation.viewmodels.CountryViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MealCountryFragment : Fragment(), ObservableEvents {

    private var _binding: FragmentMealCountryBinding? = null
    private val viewBinding get() = _binding!!

    private val viewModel: CountryViewModel by viewModel()
    private lateinit var countriesAdapter: CountriesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMealCountryBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservables()
        initView()
    }

    private fun initView() {
        viewBinding.titleNoData.visibility = View.GONE
        (activity as MainActivity).showHideProgressBar(true)
        viewModel.getMealCountry()
    }

    override fun initObservables() {
        viewModel.listCountriesLiveData.observe(viewLifecycleOwner, Observer {
            (activity as MainActivity).showHideProgressBar(false)
            when {
                it.isNotEmpty() -> {
                    viewBinding.recyclerViewMealCountry.visibility = View.VISIBLE
                    viewBinding.titleNoData.visibility = View.GONE
                    setupAdapter(it)
                }
                else -> {
                    viewBinding.titleNoData.visibility = View.VISIBLE
                }
            }
        })
    }

    private fun setupAdapter(list: List<Country>) {
        countriesAdapter = CountriesAdapter(listCountries = list)
        viewBinding.recyclerViewMealCountry.layoutManager =
            StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
        viewBinding.recyclerViewMealCountry.adapter = countriesAdapter
    }
}