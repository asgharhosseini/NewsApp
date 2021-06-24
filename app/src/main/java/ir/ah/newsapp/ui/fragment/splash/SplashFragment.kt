package ir.ah.newsapp.ui.fragment.splash

import android.os.*
import android.view.*
import androidx.fragment.app.*
import androidx.lifecycle.*
import androidx.navigation.fragment.*
import dagger.hilt.android.*
import ir.ah.newsapp.*
import ir.ah.newsapp.R
import kotlinx.coroutines.*

@AndroidEntryPoint
class SplashFragment :Fragment(R.layout.fragment_splash) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as MainActivity).hideBottomNav()
        lifecycleScope.launch {
            delay(2000)
            findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToNewsFragment())
        }
    }
}