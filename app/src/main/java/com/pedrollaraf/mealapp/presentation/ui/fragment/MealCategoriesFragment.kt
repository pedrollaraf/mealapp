package com.pedrollaraf.mealapp.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.pedrollaraf.mealapp.R
import com.pedrollaraf.mealapp.common.ListenerEvents
import com.pedrollaraf.mealapp.databinding.FragmentMealCategoriesBinding

class MealCategoriesFragment : Fragment(), ListenerEvents ,View.OnClickListener {

    private var _binding: FragmentMealCategoriesBinding? = null
    private val viewBinding get() = _binding!!

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
        initListeners()
    }

    override fun onClick(view: View) {
        when(view.id){
            R.id.toolbar_meal_country_button -> {
                findNavController().navigate(MealCategoriesFragmentDirections.actionMealCategoriesFragmentToMealCountryFragment())
            }
        }
    }

    override fun initListeners() {
        viewBinding.toolbar.toolbarMealCountryButton.setOnClickListener(this)
    }
}