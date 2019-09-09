package com.example.wardrobe.viewPager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.wardrobe.models.Pants

class PantsPagerAdapter(fragmentManager: FragmentManager, var pantsList: ArrayList<Pants>) :
    FragmentStatePagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment {
        return SingleItemFragment.newInstance(pantsList[position])
    }

    override fun getCount(): Int {
      return pantsList.size
    }
}