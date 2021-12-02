package com.example.calendertest

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import java.util.*

class CalendarFragment : Fragment() {
    val TAG = javaClass.simpleName

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_calendar, container, false)


        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val data = setData()
        var recyclerview = view?.findViewById<RecyclerView>(R.id.calendar_recyclerView)
        var calendar = Calendar.getInstance()
        calendar.set(2021,4,12)
        var calendarUtil = CalendarUtil()

        var adapter = CalendarAdapter(calendarUtil.makeMonthDate(calendar), calendar.get(Calendar.MONTH))

        recyclerview?.adapter = adapter
        recyclerview?.layoutManager = GridLayoutManager(view?.context, 7)


        //calendarUtil.setCalender()


        Log.e(TAG, calendar.time.toString() +"-----")

    }


    fun setData(): MutableList<CalendarData> {
        var data = mutableListOf<CalendarData>()

        for (num in 1..60) {
            //data.add(CalendarData(num, "gg"))

        }

        return data
    }


}