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
import com.pedrollaraf.mealapp.databinding.FragmentMealCategoriesBinding
import com.pedrollaraf.mealapp.presentation.eventclick.EventClickItemMealCategories
import com.pedrollaraf.mealapp.presentation.ui.activity.MainActivity
import com.pedrollaraf.mealapp.presentation.ui.adapters.MealCategoriesAdapter
import com.pedrollaraf.mealapp.presentation.viewmodels.MealCategoriesViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MealCategoriesFragment : Fragment(), ObservableEvents {

    private var _binding: FragmentMealCategoriesBinding? = null
    private val viewBinding get() = _binding!!

    private val viewModel: MealCategoriesViewModel by viewModel()
    private var mealCategoriesAdapter = MealCategoriesAdapter(mealCategories = listOf())

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMealCategoriesBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getListCategories()
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
        viewModel.mealCategoriesLiveData.observe(viewLifecycleOwner, Observer {
            (activity as MainActivity).showHideProgressBar(false)
            when {
                it.isNotEmpty() -> {
                    viewBinding.recyclerViewMealCategories.visibility = View.VISIBLE
                    viewBinding.titleNoData.visibility = View.GONE
                    viewBinding.noDataImage.visibility = View.GONE
                    mealCategoriesAdapter.updateList(it)
                }
                else -> {
                    viewBinding.noDataImage.visibility = View.VISIBLE
                    viewBinding.titleNoData.visibility = View.VISIBLE
                    viewBinding.recyclerViewMealCategories.visibility = View.GONE
                }
            }
        })
        mealCategoriesAdapter.eventClickItemMealCategories =
            object : EventClickItemMealCategories {
                override fun onClickItemMealCategories(categoryName: String) {
                    findNavController().navigate(
                        MealCategoriesFragmentDirections.
                        actionMealCategoriesFragmentToListMealFragment(
                            categoryName,
                            null
                        )
                    )
                }
            }
    }

    private fun initView() {
        viewBinding.noDataImage.visibility = View.GONE
        viewBinding.titleNoData.visibility = View.GONE
        (activity as MainActivity).showHideProgressBar(true)
        setupAdapter()
    }

    private fun setupAdapter() {
        viewBinding.recyclerViewMealCategories.layoutManager =
            StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
        viewBinding.recyclerViewMealCategories.adapter = mealCategoriesAdapter
    }
}