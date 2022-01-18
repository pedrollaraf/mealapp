package com.pedrollaraf.mealapp.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.pedrollaraf.mealapp.R
import com.pedrollaraf.mealapp.common.utils.ListenerEvents
import com.pedrollaraf.mealapp.common.utils.ObservableEvents
import com.pedrollaraf.mealapp.databinding.FragmentFavoriteBinding
import com.pedrollaraf.mealapp.domain.models.Meal
import com.pedrollaraf.mealapp.presentation.eventclick.EventClickItemMealSearchOrFavoriteList
import com.pedrollaraf.mealapp.presentation.ui.activity.MainActivity
import com.pedrollaraf.mealapp.presentation.ui.adapters.MealSearchFavoriteListAdapter
import com.pedrollaraf.mealapp.presentation.viewmodels.MealFavoriteViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class FragmentFavorite : Fragment(), ObservableEvents, ListenerEvents, View.OnClickListener{

    private var _binding: FragmentFavoriteBinding? = null
    private val viewBinding get() = _binding!!

    private val viewModel: MealFavoriteViewModel by viewModel()

    private var mealFavoriteAdapter = MealSearchFavoriteListAdapter(searchFavoriteList = listOf())

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initObservables()
        initListeners()
    }

    override fun initObservables() {
        viewModel.mealFavoriteLiveData.observe(viewLifecycleOwner, Observer {
            //(activity as MainActivity).showHideProgressBar(false)
            when {
                it.isNotEmpty() -> {
                    viewBinding.recyclerViewMealFavorite.visibility = View.VISIBLE
                    viewBinding.titleNoData.visibility = View.GONE
                    viewBinding.noDataImage.visibility = View.GONE
                    mealFavoriteAdapter.updateList(it)
                }
                else -> {
                    viewBinding.noDataImage.visibility = View.VISIBLE
                    viewBinding.titleNoData.visibility = View.VISIBLE
                    viewBinding.noDataImage.setImageResource(R.drawable.ic_sad)
                    viewBinding.titleNoData.setText(R.string.no_results)
                    viewBinding.recyclerViewMealFavorite.visibility = View.GONE
                }
            }
        })

        mealFavoriteAdapter.eventClickItemMealSearchOrFavoriteList =
            object : EventClickItemMealSearchOrFavoriteList {
                override fun onClickItemMealSearchFavoriteList(item: Meal) {
                    findNavController().navigate(
                        FragmentFavoriteDirections.actionFragmentFavoriteToMealDetailsFragment(
                            mealName = null,
                            meal = item
                        )
                    )
                }
            }
    }

    override fun onClick(view: View) {}

    override fun initListeners() {}

    private fun initView() {
        viewBinding.noDataImage.visibility = View.GONE
        viewBinding.titleNoData.visibility = View.GONE
        //(activity as MainActivity).showHideProgressBar(true)
        setupAdapter()
        viewModel.getListFavorite()
    }

    private fun setupAdapter() {
        viewBinding.recyclerViewMealFavorite.layoutManager =
            StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
        viewBinding.recyclerViewMealFavorite.adapter = mealFavoriteAdapter
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}