package ir.ah.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.*
import androidx.lifecycle.*
import androidx.navigation.*
import com.google.android.material.bottomnavigation.*
import dagger.hilt.android.*
import ir.ah.newsapp.databinding.*
import ir.ah.newsapp.other.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private var currentNavController: LiveData<NavController>? = null
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        if (savedInstanceState == null) {
            setupBottomNavigationBar()
        } // Else, need to wait for onRestoreInstanceState
    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        // Now that BottomNavigationBar has restored its instance state
        // and its selectedItemId, we can proceed with setting up the
        // BottomNavigationBar with Navigation
        setupBottomNavigationBar()
    }

    private fun setupBottomNavigationBar() {
        val bottomNavigationView =
            findViewById<BottomNavigationView>(binding.bnvActivityMainMain.id)
        bottomNavigationView.selectedItemId = R.id.home

        val navGraphIds = listOf(
            R.navigation.news,
            R.navigation.profile
        )

        // Setup the bottom navigation view with a list of navigation graphs
        val controller = bottomNavigationView.setupWithNavController(
            navGraphIds = navGraphIds,
            fragmentManager = supportFragmentManager,
            containerId = binding.fcvActivityMainMain.id,
            intent = intent
        )

        // Whenever the selected controller changes, setup the action bar.
        controller.observe(this, { navController ->
            //  setupNavigationView(controller.value!!)
//      setupActionBarWithNavController(navController)
        })
        currentNavController = controller
    }


    override fun onSupportNavigateUp(): Boolean {
        return currentNavController?.value?.navigateUp() ?: false
    }


    fun showBottomNav() {
        binding.bnvActivityMainMain.isVisible = true

    }

    fun hideBottomNav() {
        binding.bnvActivityMainMain.isVisible = false

    }
}