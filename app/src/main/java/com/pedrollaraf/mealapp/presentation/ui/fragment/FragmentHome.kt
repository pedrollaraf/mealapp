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
import com.pedrollaraf.mealapp.databinding.FragmentHomeBinding
import com.pedrollaraf.mealapp.domain.models.MealSearch
import com.pedrollaraf.mealapp.presentation.eventclick.EventClickItemMealHomeSearchList
import com.pedrollaraf.mealapp.presentation.ui.activity.MainActivity
import com.pedrollaraf.mealapp.presentation.ui.adapters.HomeSearchListAdapter
import com.pedrollaraf.mealapp.presentation.viewmodels.MealSearchViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*

class FragmentHome : Fragment(), ObservableEvents {

    private var _binding: FragmentHomeBinding? = null
    private val viewBinding get() = _binding!!

    private var homeSearchListAdapter = HomeSearchListAdapter(homeSearchList = listOf())
    private val viewModel: MealSearchViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initObservables()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getHomeSearchMeals(randomLetter())
    }

    fun randomLetter() : String{
        return when (Random().nextInt(5)) {
            2 -> {
                "a"
            }
            3 -> {
                "e"
            }
            4 -> {
                "i"
            }
            5 -> {
                "o"
            }
            else -> {
                "u"
            }
        }
    }

    override fun initObservables() {
        viewModel.mealHomeSearchListLiveData.observe(
            viewLifecycleOwner,
            Observer {
                handleList(it)
            })


        homeSearchListAdapter.eventClickItemMealHomeSearchList =
            object : EventClickItemMealHomeSearchList {
                override fun onClickItemMealHomeSearchList(item: MealSearch) {
                    findNavController().navigate(
                        FragmentHomeDirections.actionFragmentHomeToMealDetailsFragment(
                            mealName = null,
                            mealSearch = item
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
        viewBinding.recyclerViewMealListHome.layoutManager =
            StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
        viewBinding.recyclerViewMealListHome.adapter = homeSearchListAdapter
    }

    private fun handleList(list: List<MealSearch>) {
        (activity as MainActivity).showHideProgressBar(false)
        when {
            list.isNotEmpty() -> {
                viewBinding.recyclerViewMealListHome.visibility = View.VISIBLE
                viewBinding.titleNoData.visibility = View.GONE
                homeSearchListAdapter.updateList(list)
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