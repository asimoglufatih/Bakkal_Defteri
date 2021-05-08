package com.example.bakkaldefteri.openingscreens

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.bakkaldefteri.R
import java.util.*
import kotlin.concurrent.schedule

class SplashScreen : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        if(onBoardingFinished()){

            Timer().schedule(3000){
                lifecycleScope.launchWhenStarted{
                    findNavController().navigate(R.id.action_splashScreen_to_homeFragment,
                    null,
                    NavOptions.Builder()
                            .setPopUpTo(R.id.splashScreen,
                                    true).build())
                }
            }
        }else{
            lifecycleScope.launchWhenStarted {
                findNavController().navigate(R.id.action_splashScreen_to_viewPager,
                null,
                NavOptions.Builder().setPopUpTo(R.id.splashScreen,true).build())
            }
//            val action = SplashScreenDirections.actionSplashScreenToViewPager()
//            findNavController().navigate(action)
        }

        return inflater.inflate(R.layout.fragment_splash_screen, container, false)
    }

    private fun onBoardingFinished():Boolean {
        val sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        return sharedPref.getBoolean("Finished", false)
    }

}

