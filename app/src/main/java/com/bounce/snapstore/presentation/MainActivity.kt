package com.bounce.snapstore.presentation

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.bounce.snapstore.R
import com.bounce.snapstore.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        navView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            when (destination.id) {
                R.id.navigation_home -> {
                    binding.navView.isVisible = true
                }
                R.id.navigation_search -> {
                    binding.navView.isVisible = true
                }
                R.id.navigation_carts -> {
                    binding.navView.isVisible = true
                }
                R.id.navigation_profile -> {
                    binding.navView.isVisible = true
                }

                else -> {
                    binding.navView.isVisible = false
                }
            }
        }


    }
}