package com.pedrollaraf.mealapp.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.pedrollaraf.mealapp.common.utils.ObservableEvents
import com.pedrollaraf.mealapp.databinding.FragmentHomeBinding

class FragmentHome : Fragment(), ObservableEvents {

    private var _binding: FragmentHomeBinding? = null
    private val viewBinding get() = _binding!!


    private val args: MealDetailsFragmentArgs by navArgs()

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

    }

    private fun initView(){

    }

    override fun initObservables() {}

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}