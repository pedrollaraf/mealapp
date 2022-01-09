package com.pedrollaraf.mealapp.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pedrollaraf.mealapp.databinding.FragmentMealCategoriesBinding
import com.pedrollaraf.mealapp.presentation.viewmodels.MealCategoryViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MealCategoriesFragment : Fragment() {

    private var _binding: FragmentMealCategoriesBinding? = null
    private val viewBinding get() = _binding!!
    private val viewModel: MealCategoryViewModel by viewModel()

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
        viewModel.getMealCategories()
    }
}