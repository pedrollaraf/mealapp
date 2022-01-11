package com.pedrollaraf.mealapp.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.pedrollaraf.mealapp.common.utils.ObservableEvents
import com.pedrollaraf.mealapp.databinding.FragmentMealByCategoryBinding
import com.pedrollaraf.mealapp.presentation.eventclick.EventClickItemMealByCategoryOnList
import com.pedrollaraf.mealapp.presentation.ui.activity.MainActivity
import com.pedrollaraf.mealapp.presentation.ui.adapters.MealByCategoryAdapter
import com.pedrollaraf.mealapp.presentation.viewmodels.MealByCategoryViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MealByCategoryFragment : Fragment(), ObservableEvents {

    private var _binding: FragmentMealByCategoryBinding? = null
    private val viewBinding get() = _binding!!
    private val viewModelBy: MealByCategoryViewModel by viewModel()
    private lateinit var mealByCategoryAdapter: MealByCategoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMealByCategoryBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initObservables()
    }

    override fun initObservables() {
        viewModelBy.listMealByByCategoryLiveData.observe(viewLifecycleOwner, Observer {
            (activity as MainActivity).showHideProgressBar(false)
            when {
                it.isNotEmpty() -> {
                    viewBinding.recyclerViewMealByCategory.visibility = View.VISIBLE
                    viewBinding.titleNoData.visibility = View.GONE
                    mealByCategoryAdapter.updateList(it)
                }
                else -> {
                    viewBinding.titleNoData.visibility = View.VISIBLE
                }
            }
        })
        mealByCategoryAdapter.eventClickItemMealByCategoryOnList =
            object : EventClickItemMealByCategoryOnList {
                override fun onClickItemMealByCategory(categoryName: String) {
                    val teste = categoryName
                }
            }
    }

    private fun initView() {
        viewBinding.titleNoData.visibility = View.GONE
        (activity as MainActivity).showHideProgressBar(true)
        setupAdapter()
        viewModelBy.getMealCategories()
    }

    private fun setupAdapter() {
        mealByCategoryAdapter = MealByCategoryAdapter(listOf())
        viewBinding.recyclerViewMealByCategory.layoutManager =
            StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
        viewBinding.recyclerViewMealByCategory.adapter = mealByCategoryAdapter
    }
}