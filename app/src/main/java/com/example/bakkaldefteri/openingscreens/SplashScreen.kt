package com.example.bakkaldefteri.openingscreens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.bakkaldefteri.R
import kotlinx.android.synthetic.main.fragment_splash_screen.*
import java.util.*
import kotlin.concurrent.schedule

@Suppress("DEPRECATION")
class SplashScreen : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        Timer().schedule(3000){

            lifecycleScope.launchWhenStarted{
                findNavController().navigate(R.id.action_splashScreen_to_homeFragment,
                null,
                NavOptions.Builder()
                        .setPopUpTo(R.id.splashScreen,
                                true).build())
            }
        }

        return inflater.inflate(R.layout.fragment_splash_screen, container, false)
    }

}
