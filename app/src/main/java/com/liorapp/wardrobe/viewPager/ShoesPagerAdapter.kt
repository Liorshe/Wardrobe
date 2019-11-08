package com.liorapp.wardrobe.viewPager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.liorapp.wardrobe.models.Shoes

class ShoesPagerAdapter(fragmentManager: FragmentManager, var shoesList: ArrayList<Shoes>) :
    FragmentStatePagerAdapter(fragmentManager) {
    override fun getItem(position: Int): Fragment {

        return SingleItemFragment.newInstance(shoesList[position])
    }

    override fun getCount(): Int {
       return shoesList.size
    }
}