package com.pedrollaraf.mealapp.presentation.ui.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_FADE
import androidx.navigation.fragment.NavHostFragment
import com.pedrollaraf.mealapp.R
import com.pedrollaraf.mealapp.common.utils.ListenerEvents
import com.pedrollaraf.mealapp.common.di.DIMealManager
import com.pedrollaraf.mealapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener, ListenerEvents {

    private lateinit var viewBinding: ActivityMainBinding
    private var auxFg = "MealCategoriesFragment"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initDependencies(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        initListeners()
    }

    private fun initDependencies(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            DIMealManager().initMealDependenceInjection(application)
        }
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.toolbar_meal_country_button -> {
                val checker = checkFragment("MealCountryFragment", auxFg)
                if (!checker) {
                    auxFg = "MealCountryFragment"
                    replaceFragment(R.id.mealCountryFragment)//ID navigation
                }
            }
            R.id.toolbar_meal_category_button -> {
                val checker = checkFragment("MealCategoriesFragment", auxFg)
                if (!checker) {
                    auxFg = "MealCategoriesFragment"
                    replaceFragment(R.id.mealCategoriesFragment)//ID navigation
                }
            }
        }
    }

    private fun checkFragment(currentFragment: String, lastFragment: String): Boolean {
        return currentFragment == lastFragment
    }

    private fun replaceFragment(fragmentID: Int) {
        val navHostFragment = NavHostFragment()
        supportFragmentManager.beginTransaction()
            //viewBinding.myNavHostEstablishmentFragment.id
            .replace(viewBinding.mealNavHost.id, navHostFragment, "MealHostNav")
            .setTransition(TRANSIT_FRAGMENT_FADE)//TODO MUDAR TRANSIÇÃO
            .runOnCommit {
                val navController = navHostFragment.navController
                val navGraph = navController.navInflater.inflate(R.navigation.nav_meal)
                navGraph.startDestination = fragmentID// R.id.establishmentProfileFragment
                navController.graph = navGraph
            }.commit()
    }

    override fun initListeners() {
        viewBinding.toolbar.toolbarMealCategoryButton.setOnClickListener(this)
        viewBinding.toolbar.toolbarMealCountryButton.setOnClickListener(this)
    }
}