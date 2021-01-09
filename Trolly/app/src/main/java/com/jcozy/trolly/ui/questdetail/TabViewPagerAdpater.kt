package com.jcozy.trolly.ui.questdetail

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.jcozy.trolly.ui.questdetail.ExplanationFragment
import com.jcozy.trolly.ui.questdetail.ReviewFragment

class TabViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> ExplanationFragment()
            else -> ReviewFragment()
        }
    }

    override fun getCount(): Int = 2
}