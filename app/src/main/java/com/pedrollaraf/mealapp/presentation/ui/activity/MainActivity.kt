package com.pedrollaraf.mealapp.presentation.ui.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_FADE
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.pedrollaraf.mealapp.R
import com.pedrollaraf.mealapp.common.di.DIMealManager
import com.pedrollaraf.mealapp.common.keys.MainActivityKeys
import com.pedrollaraf.mealapp.common.utils.ListenerEvents
import com.pedrollaraf.mealapp.common.utils.Screen
import com.pedrollaraf.mealapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener, ListenerEvents {

    private lateinit var viewBinding: ActivityMainBinding
    private var auxFg = MainActivityKeys.HomeFragment.toString()
    private lateinit var navHostFragment: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initDependencies(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        initNavHostFragment()
        initListeners()
    }

    private fun initDependencies(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            DIMealManager().initMealDependenceInjection(application)
        }
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.toolbar_meal_countries_button -> {
                val checker = checkFragment(
                    MainActivityKeys.MealCountriesFragment.toString(),
                    auxFg
                )
                if (!checker) {
                    auxFg = MainActivityKeys.MealCountriesFragment.toString()
                    replaceFragment(R.id.mealCountriesFragment)//ID navigation
                }
            }
            R.id.toolbar_meal_categories_button -> {
                val checker = checkFragment(
                    MainActivityKeys.MealCategoriesFragment.toString(),
                    auxFg
                )
                if (!checker) {
                    auxFg = MainActivityKeys.MealCategoriesFragment.toString()
                    replaceFragment(R.id.mealCategoriesFragment)//ID navigation
                }
            }
            R.id.home_button ->{
                val checker = checkFragment(
                    MainActivityKeys.HomeFragment.toString(),
                    auxFg
                )
                if (!checker) {
                    auxFg = MainActivityKeys.HomeFragment.toString()
                    replaceFragment(R.id.fragmentHome)//ID navigation
                }
            }
            R.id.toolbar_back_button -> {
                findNavController(viewBinding.mealNavHost.id).popBackStack()
            }
        }
    }

    private fun checkFragment(currentFragment: String, lastFragment: String): Boolean {
        return currentFragment == lastFragment
    }

    private fun replaceFragment(fragmentID: Int) {
        supportFragmentManager.beginTransaction()
            //viewBinding.myNavHostEstablishmentFragment.id
            .replace(
                viewBinding.mealNavHost.id,
                navHostFragment,
                MainActivityKeys.MealHostNav.toString()
            )
            .setTransition(TRANSIT_FRAGMENT_FADE)//TODO MUDAR TRANSIÇÃO
            .runOnCommit {
                val navController = navHostFragment.navController
                val navGraph = navController.navInflater.inflate(R.navigation.nav_meal)
                navGraph.startDestination = fragmentID// R.id.establishmentProfileFragment
                navController.graph = navGraph
            }.commit()
    }

    private fun initNavHostFragment() {
        navHostFragment = supportFragmentManager.findFragmentById(
            R.id.meal_nav_host
        ) as NavHostFragment
    }

    override fun initListeners() {
        viewBinding.toolbar.toolbarMealCategoriesButton.setOnClickListener(this)
        viewBinding.toolbar.toolbarMealCountriesButton.setOnClickListener(this)
        viewBinding.toolbar.toolbarBackButton.setOnClickListener(this)
        viewBinding.homeButton.setOnClickListener(this)

        navHostFragment.navController.addOnDestinationChangedListener { controller, destination, arguments ->
            if (destination.id == R.id.listMealFragment || destination.id == R.id.mealDetailsFragment) {
                viewBinding.toolbar.toolbarBackButton.visibility = View.VISIBLE
                viewBinding.toolbar.toolbarMealCategoriesButton.visibility = View.GONE
                viewBinding.toolbar.toolbarMealFavoriteButton.visibility = View.GONE
                viewBinding.toolbar.toolbarMealCountriesButton.visibility = View.GONE
            } else {
                viewBinding.toolbar.toolbarBackButton.visibility = View.GONE
                viewBinding.toolbar.toolbarMealCategoriesButton.visibility = View.VISIBLE
                viewBinding.toolbar.toolbarMealFavoriteButton.visibility = View.VISIBLE
                viewBinding.toolbar.toolbarMealCountriesButton.visibility = View.VISIBLE
            }
        }

    }

    fun showHideProgressBar(visibility: Boolean) {
        if (visibility) {
            viewBinding.progressBar.visibility = View.VISIBLE
            viewBinding.activityContent.alpha = 0.2f
            Screen.enableDisableView(this, false)


        } else {
            viewBinding.progressBar.visibility = View.GONE
            viewBinding.activityContent.alpha = 1f
            Screen.enableDisableView(this, true)
        }
    }
}