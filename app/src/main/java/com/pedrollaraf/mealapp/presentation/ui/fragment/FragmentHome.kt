package com.pedrollaraf.mealapp.presentation.ui.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.pedrollaraf.mealapp.common.utils.ObservableEvents
import com.pedrollaraf.mealapp.databinding.FragmentHomeBinding
import com.pedrollaraf.mealapp.domain.models.Meal
import com.pedrollaraf.mealapp.presentation.eventclick.EventClickItemMealSearchOrFavoriteList
import com.pedrollaraf.mealapp.presentation.ui.activity.MainActivity
import com.pedrollaraf.mealapp.presentation.ui.adapters.MealSearchFavoriteListAdapter
import com.pedrollaraf.mealapp.presentation.viewmodels.MealSearchViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*
import com.pedrollaraf.mealapp.R
import com.pedrollaraf.mealapp.common.utils.Keyboard
import com.pedrollaraf.mealapp.common.utils.ListenerEvents

class FragmentHome : Fragment(), ObservableEvents, ListenerEvents, View.OnClickListener {

    private var _binding: FragmentHomeBinding? = null
    private val viewBinding get() = _binding!!

    private var homeSearchListAdapter = MealSearchFavoriteListAdapter(searchFavoriteList = listOf())
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
        initListeners()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getHomeSearchMeals(randomLetter())
    }

    private fun randomLetter(): String {
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

    override fun initListeners() {
        viewBinding.homeSearchView.searchButton.setOnClickListener(this)
        viewBinding.homeSearchView.closeSearchButton.setOnClickListener(this)

        viewBinding.homeSearchView.edittextSearch.setOnKeyListener(object : View.OnKeyListener {
            override fun onKey(view: View, keyCode: Int, event: KeyEvent): Boolean {
                if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                    (activity as MainActivity).showHideProgressBar(true)
                    Keyboard.hideKeyboard(requireView())
                    viewModel.getHomeSearchMeals(
                        viewBinding.homeSearchView.edittextSearch.text.toString()
                    )
                    return true
                }
                return false
            }
        })

        viewBinding.homeSearchView.edittextSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s.isNullOrBlank()) {
                    viewBinding.homeSearchView.closeSearchButton.visibility = View.GONE
                } else {
                    if (viewBinding.homeSearchView.closeSearchButton.visibility != View.VISIBLE) {
                        viewBinding.homeSearchView.closeSearchButton.visibility = View.VISIBLE
                    }
                }
            }

            override fun afterTextChanged(s: Editable?) {}
        })
    }

    override fun initObservables() {
        viewModel.mealHomeSearchListLiveData.observe(
            viewLifecycleOwner,
            Observer {
                handleList(it)
            })


        homeSearchListAdapter.eventClickItemMealSearchOrFavoriteList =
            object : EventClickItemMealSearchOrFavoriteList {
                override fun onClickItemMealSearchFavoriteList(item: Meal) {
                    findNavController().navigate(
                        FragmentHomeDirections.actionFragmentHomeToMealDetailsFragment(
                            mealName = null,
                            meal = item
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
        viewBinding.recyclerViewMealListHome.layoutManager =
            StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
        viewBinding.recyclerViewMealListHome.adapter = homeSearchListAdapter
    }

    private fun handleList(list: List<Meal>) {
        (activity as MainActivity).showHideProgressBar(false)
        when {
            list.isNotEmpty() -> {
                viewBinding.recyclerViewMealListHome.visibility = View.VISIBLE
                viewBinding.titleNoData.visibility = View.GONE
                viewBinding.noDataImage.visibility = View.GONE
                homeSearchListAdapter.updateList(list)
            }
            else -> {
                viewBinding.noDataImage.visibility = View.VISIBLE
                viewBinding.titleNoData.visibility = View.VISIBLE
                viewBinding.recyclerViewMealListHome.visibility = View.GONE
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.search_button -> {
                viewBinding.homeSearchView.edittextSearch.requestFocus()
                Keyboard.showKeyboard(viewBinding.homeSearchView.edittextSearch)
            }
            R.id.close_search_button -> {
                viewBinding.homeSearchView.edittextSearch.clearFocus()
                Keyboard.hideKeyboard(requireView())
                viewBinding.homeSearchView.edittextSearch.setText("")
                (activity as MainActivity).showHideProgressBar(true)
                viewModel.getHomeSearchMeals(randomLetter())
            }
        }
    }
}