package com.bounce.snapstore.presentation.ui

import android.content.Context
import android.os.Bundle
import android.util.TypedValue
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.insets.GradientProtection
import androidx.core.view.isVisible
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.bounce.snapstore.R
import com.bounce.snapstore.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()


        val navView: BottomNavigationView = binding.navView
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        navController.setGraph(R.navigation.mobile_navigation)
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

        binding.mainContainerProtectionLayout.setProtections(
            listOf(
                GradientProtection(
                    WindowInsetsCompat.Side.TOP,
                    getColor(R.color.orange_700)
                )
            )
        )


    }

    fun Context.getActionBarHeightInPixels(): Int {
        val typedValue = TypedValue()
        if (theme.resolveAttribute(android.R.attr.actionBarSize, typedValue, true)) {
            return TypedValue.complexToDimensionPixelSize(typedValue.data, resources.displayMetrics)
        }
        return 0 // Return 0 if the attribute cannot be resolved
    }

}