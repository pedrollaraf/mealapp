package com.pedrollaraf.mealapp.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.pedrollaraf.mealapp.common.utils.ObservableEvents
import com.pedrollaraf.mealapp.databinding.FragmentListMealBinding
import com.pedrollaraf.mealapp.domain.models.MealFromCategoryOrCountry
import com.pedrollaraf.mealapp.presentation.eventclick.EventClickItemMealList
import com.pedrollaraf.mealapp.presentation.ui.activity.MainActivity
import com.pedrollaraf.mealapp.presentation.ui.adapters.MealListAdapter
import com.pedrollaraf.mealapp.presentation.viewmodels.MealListFromCategoryViewModel
import com.pedrollaraf.mealapp.presentation.viewmodels.MealListFromCountryViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MealListFragment : Fragment(), ObservableEvents {

    private var _binding: FragmentListMealBinding? = null
    private val viewBinding get() = _binding!!

    private val viewModelMealListFromCategory: MealListFromCategoryViewModel by viewModel()
    private val viewModelMealListFromCountry: MealListFromCountryViewModel by viewModel()
    private val args: MealListFragmentArgs by navArgs()

    private var mealListAdapter = MealListAdapter(mealFromCategoryOrCountryList = listOf())

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListMealBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initObservables()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val categoryName = args.categoryName
        val countryName = args.countryName

        when {
            !categoryName.isNullOrBlank() -> {
                viewModelMealListFromCategory.getListMealsFromCategory(categoryName)
            }
            !countryName.isNullOrBlank() -> {
                viewModelMealListFromCountry.getListMealsFromCountry(countryName)
            }
            else -> {
                viewBinding.titleNoData.visibility = View.VISIBLE
                viewBinding.recyclerViewMealList.visibility = View.VISIBLE
            }
        }
    }

    override fun initObservables() {
        viewModelMealListFromCategory.listMealFromCategoryLiveData.observe(
            viewLifecycleOwner,
            Observer {
                handleList(it)
            })

        viewModelMealListFromCountry.listMealFromCountryLiveData.observe(
            viewLifecycleOwner,
            Observer {
                handleList(it)
            })

        mealListAdapter.eventClickItemMealList =
            object : EventClickItemMealList {
                override fun onClickItemMealList(itemName: String) {
                    findNavController().navigate(
                        MealListFragmentDirections.actionListMealFragmentToMealDetailsFragment(
                            mealName = itemName,
                            mealSearch = null
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
        viewBinding.recyclerViewMealList.layoutManager =
            StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
        viewBinding.recyclerViewMealList.adapter = mealListAdapter
    }

    private fun handleList(list: List<MealFromCategoryOrCountry>) {
        (activity as MainActivity).showHideProgressBar(false)
        when {
            list.isNotEmpty() -> {
                viewBinding.recyclerViewMealList.visibility = View.VISIBLE
                viewBinding.titleNoData.visibility = View.GONE
                mealListAdapter.updateList(list)
            }
            else -> {
                viewBinding.titleNoData.visibility = View.VISIBLE
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}