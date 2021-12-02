package com.example.calendertest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2

class VerticalFragment : Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?{

        val view = inflater.inflate(R.layout.fragment_vertical,container,false)

        var viewPagerLayout = view.findViewById<ViewPager2>(R.id.layout_viewpager2)
        var viewPagerAdapter = ViewPagerAdapter(this)
        viewPagerAdapter.setType(ViewPagerAdapter.HORIZONTAL_TYPE)
        viewPagerLayout.adapter = viewPagerAdapter

        return view
    }
}