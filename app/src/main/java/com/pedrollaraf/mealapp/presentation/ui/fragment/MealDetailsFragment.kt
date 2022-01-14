package com.pedrollaraf.mealapp.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import coil.load
import com.pedrollaraf.mealapp.R
import com.pedrollaraf.mealapp.common.utils.ObservableEvents
import com.pedrollaraf.mealapp.databinding.FragmentMealDetailsBinding
import com.pedrollaraf.mealapp.domain.models.MealSearch
import com.pedrollaraf.mealapp.presentation.viewmodels.MealDetailsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MealDetailsFragment : Fragment(), ObservableEvents {

    private var _binding: FragmentMealDetailsBinding? = null
    private val viewBinding get() = _binding!!

    private var mealSearch: MealSearch? = null


    private val args: MealDetailsFragmentArgs by navArgs()
    private val viewModel: MealDetailsViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMealDetailsBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initObservables()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    private fun initView() {
        mealSearch = args.mealSearch

        if (mealSearch != null) {
            viewBinding.mealName.text = mealSearch?.strMeal
            viewBinding.mealCategoryName.text = mealSearch?.strCategory
            viewBinding.mealCountryName.text = mealSearch?.strArea
            viewBinding.mealIngredients.text = viewModel.getCompileListIngredients(
                mealSearch
            )
            viewBinding.mealMeasures.text = viewModel.getCompileListMeasures(
                mealSearch
            )
            viewBinding.mealInstructions.text = mealSearch?.strInstructions

            viewBinding.imageMeal.load(mealSearch?.strMealThumb) {
                listener(
                    // pass two arguments
                    onSuccess = { _, _ ->
                        viewBinding.progressBarImage.visibility = View.GONE
                        viewBinding.imageMeal.visibility = View.VISIBLE
                    },
                    onError = { _, _ ->
                        viewBinding.progressBarImage.visibility = View.GONE
                        viewBinding.imageMeal.visibility = View.VISIBLE
                        viewBinding.imageMeal.setImageResource(R.drawable.ic_error)
                    }
                )
            }
        } else {
            viewBinding.mealName.text = args.mealName
        }
    }

    override fun initObservables() {}

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}