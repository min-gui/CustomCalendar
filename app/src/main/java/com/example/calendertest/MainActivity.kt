package com.example.calendertest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


class MainActivity : AppCompatActivity() {

    lateinit var viewPager : ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.layout_viewpager2)
        val viewPagerAdapter = ViewPagerAdapter(this)
        viewPagerAdapter.setType(ViewPagerAdapter.VERTICAL_TYPE)
        viewPager.adapter = viewPagerAdapter

        test()

    }
    fun test() = runBlocking{

//        launch {
//            delay(200L)
//            println("1. Task from runBlocking")
//        }
        coroutineScope {
            launch {
                delay(500L)
                println("2. Task from nested launch")
            }
//            delay(100L)
//            println("3. Task from coroutine scope")
        }
        println("4. Coroutine scope is over")



    }



}