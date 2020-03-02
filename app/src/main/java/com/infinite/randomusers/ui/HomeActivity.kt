package com.infinite.randomusers.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.navigateUp
import com.infinite.randomusers.R
import kotlinx.android.synthetic.main.activity_main.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navController = this.findNavController(R.id.homeNavHostFragment)
        NavigationUI.setupActionBarWithNavController(this, navController)
        supportActionBar?.apply {
            setBackgroundDrawable(getDrawable(R.drawable.toolbar_gradient))
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.homeNavHostFragment)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

}
