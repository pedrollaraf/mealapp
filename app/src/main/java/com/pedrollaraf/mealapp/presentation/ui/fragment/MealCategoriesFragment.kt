package com.pedrollaraf.mealapp.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.pedrollaraf.mealapp.common.utils.ObservableEvents
import com.pedrollaraf.mealapp.databinding.FragmentMealCategoriesBinding
import com.pedrollaraf.mealapp.domain.models.MealCategory
import com.pedrollaraf.mealapp.presentation.ui.activity.MainActivity
import com.pedrollaraf.mealapp.presentation.ui.adapters.MealCategoriesAdapter
import com.pedrollaraf.mealapp.presentation.viewmodels.MealCategoryViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MealCategoriesFragment : Fragment(), ObservableEvents {

    private var _binding: FragmentMealCategoriesBinding? = null
    private val viewBinding get() = _binding!!
    private val viewModel: MealCategoryViewModel by viewModel()
    private lateinit var mealCategoriesAdapter: MealCategoriesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMealCategoriesBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservables()
        initView()
    }

    override fun initObservables() {
        viewModel.listMealCategoriesLiveData.observe(viewLifecycleOwner, Observer {
            (activity as MainActivity).showHideProgressBar(false)
            when {
                it.isNotEmpty() -> {
                    viewBinding.recyclerViewMealCategories.visibility = View.VISIBLE
                    viewBinding.titleNoData.visibility = View.GONE
                    setupAdapter(it)
                }
                else -> {
                    viewBinding.titleNoData.visibility = View.VISIBLE
                }
            }
        })
    }

    private fun initView() {
        viewBinding.titleNoData.visibility = View.GONE
        (activity as MainActivity).showHideProgressBar(true)
        viewModel.getMealCategories()
    }

    private fun setupAdapter(list: List<MealCategory>) {
        mealCategoriesAdapter = MealCategoriesAdapter(listMealCategories = list)
        viewBinding.recyclerViewMealCategories.layoutManager =
            StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
        viewBinding.recyclerViewMealCategories.adapter = mealCategoriesAdapter
    }
}