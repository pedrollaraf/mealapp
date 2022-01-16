package com.pedrollaraf.mealapp.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import coil.load
import com.pedrollaraf.mealapp.R
import com.pedrollaraf.mealapp.common.utils.ListenerEvents
import com.pedrollaraf.mealapp.common.utils.ObservableEvents
import com.pedrollaraf.mealapp.databinding.FragmentMealDetailsBinding
import com.pedrollaraf.mealapp.domain.models.Meal
import com.pedrollaraf.mealapp.presentation.viewmodels.MealDetailsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MealDetailsFragment : Fragment(), ObservableEvents, ListenerEvents, View.OnClickListener {

    private var _binding: FragmentMealDetailsBinding? = null
    private val viewBinding get() = _binding!!

    private var meal: Meal? = null


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
        initListeners()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mealName = args.mealName

        if(!mealName.isNullOrEmpty()){
            viewModel.getMealDetails(mealName)
        }
    }

    private fun initView() {
        meal = args.meal

        if (meal != null) {
            handleView(meal!!)
        } else {
            viewBinding.mealName.text = args.mealName
        }
    }

    override fun initObservables() {
        viewModel.mealSearchLiveData.observe(viewLifecycleOwner, Observer {
            meal = it
            handleView(it)
        })
    }

    override fun initListeners() {
        viewBinding.mealFavoriteButton.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when(view.id){
            R.id.meal_favorite_button -> {
                val currentMeal = meal
                if(currentMeal != null) {
                    viewModel.favoriteMeal(currentMeal)
                }
                //viewBinding.mealFavoriteButton.setImageResource(R.drawable.ic_favorite_enabled)
            }
        }
    }

    private fun handleView(meal: Meal){
        viewBinding.mealName.text = meal.strMeal
        viewBinding.mealCategoryName.text = meal.strCategory
        viewBinding.mealCountryName.text = meal.strArea
        viewBinding.mealIngredients.text = viewModel.getCompileListIngredients(
            meal
        )
        viewBinding.mealMeasures.text = viewModel.getCompileListMeasures(
            meal
        )
        viewBinding.mealInstructions.text = meal.strInstructions

        viewBinding.imageMeal.load(meal.strMealThumb) {
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
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}