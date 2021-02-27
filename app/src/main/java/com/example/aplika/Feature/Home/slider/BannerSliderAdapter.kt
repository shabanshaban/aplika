package com.example.aplika.Feature.Home.slider

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.aplika.Data.model.Banner

class BannerSliderAdapter(fragment: Fragment, val listBanner:List<Banner>) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return listBanner.size
    }

    override fun createFragment(position: Int): Fragment  =FragmentBanner.newInstance(listBanner[position])

}