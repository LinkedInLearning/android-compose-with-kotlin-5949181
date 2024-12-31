package com.example.red30.viewbased

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.red30.R
import com.example.red30.databinding.ActivityMainViewBinding

class MainViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainViewBinding

    val navController: NavController by lazy {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navHostFragment.navController
    }

    val appBarConfiguration: AppBarConfiguration by lazy {
        AppBarConfiguration(
            setOf(R.id.sessionsFragment, R.id.speakersFragment, R.id.favoritesFragment)
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainViewBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setSupportActionBar(findViewById(R.id.toolbar))

        navController.addOnDestinationChangedListener { _, _, arguments ->
            binding.bottomNav.isVisible = arguments?.getBoolean("show_bottom_bar", true) == true
        }

        binding.bottomNav.setupWithNavController(navController)
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navigateUp(navController, appBarConfiguration) || super.onSupportNavigateUp()
    }
}
