package com.liorapp.wardrobe.viewPager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.liorapp.wardrobe.models.Shirt

class ShirtPagerAdapter(fragmentManager: FragmentManager, var shirtList: ArrayList<Shirt>) :
    FragmentStatePagerAdapter(fragmentManager) {


    override fun getItem(position: Int): Fragment {
        return SingleItemFragment.newInstance(shirtList[position])
    }

    override fun getCount(): Int {
       return shirtList.size
    }
}