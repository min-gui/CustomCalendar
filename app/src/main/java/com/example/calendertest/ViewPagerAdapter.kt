package com.example.calendertest

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

/**
 * Created by minsub on 22/03/2019.
 */



class ViewPagerAdapter : FragmentStateAdapter {

    private var type = 0
    private var count = 0

    val TAG = javaClass.simpleName

    companion object{
        const val VERTICAL_TYPE = 1000
        const val HORIZONTAL_TYPE = 1001
    }

    constructor(fa: FragmentActivity) : super(fa)
    constructor(fa: Fragment) : super(fa)

    fun setType(type: Int) {
        this.type = type
    }

    override fun getItemCount(): Int {
        //TODO("Not yet implemented")
        Log.e(TAG, "getItemCount")
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        //TODO("Not yet implemented")
        return if (type == VERTICAL_TYPE){

            Log.e(TAG, "position_ver : " + position)
            CalendarFragment()
        }else{

            Log.e(TAG, "position_hori : " + position)
            HorizontalFragment()

        }
    }
}