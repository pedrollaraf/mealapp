package com.pedrollaraf.mealapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.pedrollaraf.mealapp.R
import com.pedrollaraf.mealapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.toolbar.toolbarStartButton.setOnClickListener {
            Toast.makeText(this,"Back Meal",Toast.LENGTH_SHORT).show()
        }

        viewBinding.toolbar.toolbarEndOneButton.setOnClickListener {
            Toast.makeText(this,"Location Meal",Toast.LENGTH_SHORT).show()
        }

        viewBinding.toolbar.toolbarEndTwoButton.setOnClickListener {
            Toast.makeText(this,"Category Meal",Toast.LENGTH_SHORT).show()
        }
    }
}