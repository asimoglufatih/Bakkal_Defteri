package com.example.bakkaldefteri.openingscreens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.bakkaldefteri.R

class ViewPagerAdapter(
    list:ArrayList<Fragment>,
    fm: FragmentManager, lifecycle: Lifecycle
) : FragmentStateAdapter(fm,lifecycle) {

    private val fragmentList :ArrayList<Fragment> = list
    override fun getItemCount(): Int {
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }
}