package com.example.bakkaldefteri.openingscreens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.viewpager2.widget.ViewPager2
import com.example.bakkaldefteri.R

class FirstOnboardingScreen : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view =  inflater.inflate(R.layout.fragment_first_onboarding_screen, container, false)

        val viewpager = activity?.findViewById<ViewPager2>(R.id.view_pager)

        view.findViewById<Button>(R.id.firstOnboardingScreenButton).setOnClickListener {
            viewpager?.currentItem = 1
        }

        return inflater.inflate(R.layout.fragment_first_onboarding_screen, container, false)
    }

}