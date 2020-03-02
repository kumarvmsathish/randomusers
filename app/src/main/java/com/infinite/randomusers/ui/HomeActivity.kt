package com.infinite.randomusers.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.infinite.randomusers.R

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
