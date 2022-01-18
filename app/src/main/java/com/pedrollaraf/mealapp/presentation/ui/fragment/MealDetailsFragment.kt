package com.pedrollaraf.mealapp.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import coil.load
import com.pedrollaraf.mealapp.R
import com.pedrollaraf.mealapp.common.keys.FavoriteKeys
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
    private var mealName: String = ""
    private var isMealFavorite: Boolean = false


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
        initObservables()
        initListeners()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mealName = args.mealName.orEmpty()
        meal = args.meal

        viewModel.getListFavorite()
    }

    override fun initObservables() {

        viewModel.isMealFavoriteLiveData.observe(viewLifecycleOwner, Observer {
            if(it == FavoriteKeys.FAVORITED.toString()){
                isMealFavorite = true
                viewBinding.mealFavoriteButton.setImageResource(R.drawable.ic_favorite_enabled)
            }else{
                isMealFavorite = false
                viewBinding.mealFavoriteButton.setImageResource(R.drawable.ic_favorite_disabled)
            }
        })

        viewModel.mealSearchLiveData.observe(viewLifecycleOwner, Observer {
            meal = it
            handleView(it)
        })

        viewModel.mealFavoriteLiveData.observe(viewLifecycleOwner, Observer {
            if(it.isNotEmpty()){
                if(mealName.isNotEmpty()){
                    val mealFavoriteFromLocalByName = viewModel.getMealFromFavoriteList(mealName, it)
                    if(mealFavoriteFromLocalByName != null){
                        handleView(mealFavoriteFromLocalByName)
                        viewBinding.mealFavoriteButton.setImageResource(
                            R.drawable.ic_favorite_enabled
                        )
                        isMealFavorite = true
                    }else{
                        viewModel.getMealDetails(mealName)
                    }

                }else{
                    val mealFavoriteFromLocalByObj = viewModel.getMealFromFavoriteList(meal!!.strMeal!!, it)
                    if(mealFavoriteFromLocalByObj != null){
                        handleView(mealFavoriteFromLocalByObj)
                        viewBinding.mealFavoriteButton.setImageResource(
                            R.drawable.ic_favorite_enabled
                        )
                        isMealFavorite = true
                    }else{
                        viewModel.getMealDetails(meal!!.strMeal!!)
                    }
                }
            }else{
                if(mealName.isNotEmpty()){
                    viewModel.getMealDetails(mealName)
                }else{
                    viewModel.getMealDetails(meal!!.strMeal!!)
                }
            }
        })
    }

    override fun initListeners() {
        viewBinding.mealFavoriteButton.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.meal_favorite_button -> {
                if(isMealFavorite){
                    viewModel.unFavoriteMeal(meal!!)
                }else{
                    viewModel.favoriteMeal(meal!!)
                }
            }
        }
    }

    private fun handleView(meal: Meal?) {
        if(meal != null) {
            //Image
            viewBinding.imageMeal.load(meal.strMealThumb) {
                listener(
                    // pass two arguments
                    onSuccess = { _, _ ->
                        viewBinding.progressBarImage.visibility = View.GONE
                        viewBinding.imageMeal.visibility = View.VISIBLE
                        viewBinding.imageMeal.scaleType = ImageView.ScaleType.CENTER_CROP
                    },
                    onError = { _, _ ->
                        viewBinding.progressBarImage.visibility = View.GONE
                        viewBinding.imageMeal.visibility = View.VISIBLE
                        viewBinding.imageMeal.scaleType = ImageView.ScaleType.FIT_CENTER
                        viewBinding.imageMeal.setImageResource(R.drawable.ic_error)
                    }
                )
            }

            //First Card
            viewBinding.mealName.text = meal.strMeal
            viewBinding.mealFavoriteButton.visibility = View.VISIBLE

            viewBinding.noData.visibility = View.GONE
            viewBinding.noDataImage.visibility = View.GONE

            viewBinding.mealCategoryName.visibility = View.VISIBLE
            viewBinding.mealCategoryImage.visibility = View.VISIBLE
            viewBinding.mealCategoryName.text = meal.strCategory

            viewBinding.mealCountryName.visibility = View.VISIBLE
            viewBinding.mealCountryImage.visibility = View.VISIBLE
            viewBinding.mealCountryName.text = meal.strArea

            //Ingredients and Measures
            viewBinding.mealIngredientsTitle.visibility = View.VISIBLE
            viewBinding.mealMeasuresTitle.visibility = View.VISIBLE

            viewBinding.mealIngredients.visibility = View.VISIBLE
            viewBinding.mealIngredients.text = viewModel.getCompileListIngredients(
                meal
            )
            viewBinding.mealMeasures.visibility = View.VISIBLE
            viewBinding.mealMeasures.text = viewModel.getCompileListMeasures(
                meal
            )

            //Instructions

            viewBinding.contentInfoInstructions.visibility = View.VISIBLE
            viewBinding.mealInstructions.text = meal.strInstructions


        }else{
            //Image
            viewBinding.progressBarImage.visibility = View.GONE
            viewBinding.imageMeal.visibility = View.VISIBLE
            viewBinding.imageMeal.setImageResource(R.drawable.ic_error)
            viewBinding.imageMeal.scaleType = ImageView.ScaleType.FIT_CENTER

            //First Card
            viewBinding.mealName.text = getString(R.string.oh_no)
            viewBinding.mealFavoriteButton.visibility = View.GONE
            viewBinding.mealCategoryImage.visibility = View.GONE
            viewBinding.mealCategoryName.visibility = View.GONE
            viewBinding.mealCountryImage.visibility = View.GONE
            viewBinding.mealCountryName.visibility = View.GONE
            viewBinding.noData.visibility = View.VISIBLE
            viewBinding.noDataImage.visibility = View.VISIBLE

            //Ingredients and Measures
            viewBinding.mealIngredientsTitle.visibility = View.GONE
            viewBinding.mealMeasuresTitle.visibility = View.GONE
            viewBinding.mealIngredients.visibility = View.GONE
            viewBinding.mealMeasures.visibility = View.GONE

            //Instructions
            viewBinding.contentInfoInstructions.visibility = View.GONE
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}