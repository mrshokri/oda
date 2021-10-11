package com.android.oda.features.mainActivity

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.android.oda.R
import com.android.oda.appUtilities.extensions.hideKeyboard
import com.android.oda.appUtilities.util.ui.components.toolbar.Toolbar
import com.android.oda.appUtilities.util.ui.components.toolbar.ToolbarConfig
import com.android.oda.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ToolbarHost {

    companion object {
        private const val TAG = "MainActivity"
    }

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Oda)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        configureUI()
    }

    override fun onDestroy() {
        binding.root.hideKeyboard()
        super.onDestroy()
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        setIntent(intent)
    }

    private fun configureUI() {
        configureStatusBar()
        configureNavigation()
    }

    private fun configureStatusBar() {
        window.decorView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR//  set status text dark
        window.statusBarColor =
            ContextCompat.getColor(this, R.color.white)// set status background white
    }

    override fun setToolbarConfig(config: ToolbarConfig): Toolbar {
        binding.toolbar.setConfig(config)
        return binding.toolbar
    }

    private fun configureNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    fun hideToolbar() {
        if (binding.toolbar.isVisible) {
            binding.toolbar.visibility = GONE
        }
    }

    fun showToolbar() {
        if (!binding.toolbar.isVisible) {
            binding.toolbar.visibility = VISIBLE
        }
    }

    fun getToolbar(): Toolbar {
        return binding.toolbar
    }

    private fun showToast(message: String) {
        Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT).show()
    }
}