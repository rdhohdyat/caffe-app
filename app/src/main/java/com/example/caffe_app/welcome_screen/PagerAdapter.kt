package com.example.caffe_app.welcome_screen

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter

class PagerAdapter (
    activity: WelcomeActivityFragment,
    private val fragments: List<Fragment>
) : FragmentStateAdapter(activity){

    override fun getItemCount() : Int {
        return  fragments.size
    }

    override fun createFragment(position: Int) : Fragment {
        return fragments[position]
    }
}